package UX;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import DAO.*;
import Entity.User;
import JpaUtils.CookieUtils;

@WebServlet({"/sign-in", "/sign-up", "/sign-out"})
public class userLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();		
		if (uri.contains("sign-in")) {			
			this.doSignIn(req, resp);
			
		}else if (uri.contains("sign-up")) {
			this.doSignUp(req, resp);
		}else if (uri.contains("sign-out")) {
			req.getSession().setAttribute("user", null);
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}

	private void doSignIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		if (method.equalsIgnoreCase(method)) {
			
			String userName = req.getParameter("id");
			String pass = req.getParameter("password");
			UserDAO dao = new UserDAO();
			try {
				User us = dao.selectById(userName);
				if (!us.getPassword().equals(pass)) {

					req.setAttribute("MessageUser", "Sai Mật Khẩu");
				} else {
					int hours = 30*24;
					req.setAttribute("MessageUser", "Thành Công");
					req.getSession().setAttribute("user", us);
					CookieUtils.add("id", userName, hours, resp);
					CookieUtils.add("password", pass, hours, resp);
					req.getRequestDispatcher("/user/TrangChu").forward(req, resp);
	
				}
			
			}

			catch (Exception e) {
				req.setAttribute("MessageUser", "Sai tài khoảng");
			}
			
		}
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
	private void doSignUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();
		if(method.equalsIgnoreCase("POST")) {
			// TODO: ĐĂNG KÝ
			try {
				User entity = new User();
				BeanUtils.populate(entity, req.getParameterMap());
				entity.setAdmin(false);
				UserDAO dao = new UserDAO();
				dao.insert(entity);
				req.setAttribute("message", "thành công!");
			} catch (Exception e) {
				req.setAttribute("message", "Lỗi đăng ký!");
			}
		}
//		
		req.getRequestDispatcher("/views/Dk.jsp").forward(req, resp);
	}
}
