package UX;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import DAO.ReportDAO;
import DAO.UserDAO;
import DAO.VideoDAO;
import Entity.User;
import JpaUtils.CookieUtils;

@WebServlet({ "/user/TrangChu", "/user/videoLike", "/user/historyWatch", "/user/change", "/user/profile",
		"/manager/TrangChu", "/manager/QLvideo", "/manager/QLnguoiDung", "/manager/thongKe", "/ChiTiet","/selectVideoKey"})

public class TrangChu extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		VideoDAO Vdao = new VideoDAO();
		UserDAO Udao = new UserDAO();
		User user = new User();
		if (uri.contains("/user/change")) {
			req.setAttribute("view", "/views/profile/profile.jsp");
		}
		if (uri.contains("/user/historyWatch")) {
			req.setAttribute("view", "/views/videolike.jsp");
		}

		else if (uri.contains("/user/profile")) {
//			String uriprofile = req.getRequestURI();
//			if (uriprofile.contains("/user/profile")) {
			req.getSession().setAttribute("us", req.getSession().getAttribute("user"));
			req.getRequestDispatcher("/change/pass").forward(req, resp);
//			} else if (uriprofile.contains("/change/passNew")) {
//				req.getRequestDispatcher("/change/passNew").forward(req, resp);
//			}

		} else if (uri.contains("/user/TrangChu")) {
			VideoDAO dao = new VideoDAO();
			if (uri.contains("/TrangChu") ) {
				req.setAttribute("AllPhim", dao.selectAll());
			}						
			req.setAttribute("views", "/views/slide.jsp");
			req.setAttribute("view", "/views/PHIM.jsp");
		
		}
		else if (uri.contains("/selectVideoKey")) {
			String title = req.getParameter("title");
			//req.setAttribute("VideoKey", dao.selecByKeyword(title));
			req.setAttribute("views", "/views/searchPhim.jsp");
		}
		else if (uri.contains("/ChiTiet")) {
			VideoDAO dao = new VideoDAO();		
			boolean demso = false;
//			int dem = 0;					
//			if( == null) {
//				dem = 0;			
//			}	
//				dem++;
//				System.out.println(dem);
//				if(dem % 2 ==0) {
//					demso = true;
//				}else {
//					demso = false;
//				}
//			
//			
		
			req.setAttribute("AllPhim", dao.selectAll());
			req.setAttribute("actip", demso);
			req.setAttribute("view", "/views/ChiTiet.jsp");

		} else if (uri.contains("/user/videoLike")) {
			req.setAttribute("views", "/views/videolike.jsp");
		} else if (uri.contains("/manager/QLvideo")) {
			if (uri.contains("editVideo")) {
				req.getRequestDispatcher("/editVideo/*").forward(req, resp);
			}
			req.setAttribute("view", "/views/QLVideo.jsp");
		} else if (uri.contains("/manager/QLnguoiDung")) {
			if (uri.contains("editUsers")) {
				req.getRequestDispatcher("/editUsers/*").forward(req, resp);
			}
			req.setAttribute("view", "/views/QLNguoiDung.jsp");

		} else if (uri.contains("/manager/thongKe")) {
			// req.getRequestDispatcher("/Favorites").forward(req, resp);
			ReportDAO dao = new ReportDAO();
			VideoDAO vdao = new VideoDAO();	
			String title1 = req.getParameter("CHÌA KHÓA 100 TỶ | OFFICIAL MV");
			if(title1 == null) {
				title1 ="CHÌA KHÓA 100 TỶ | OFFICIAL MV";
			}
			System.out.println("title1 " + title1);
			req.setAttribute("like", dao.SumLike());
		//	req.setAttribute("user",dao.SelectByLikeTitle(title1) );
			req.setAttribute("titleVideo", vdao.selectAll());
			req.setAttribute("views", "/views/ThongKe.jsp");
			

		}
		String username = CookieUtils.get("username", req);
		String password = CookieUtils.get("password", req);
		req.setAttribute("username", username);
		req.setAttribute("password", password);
		req.setAttribute("videoALL", Vdao.selectAll());
		req.setAttribute("userAll", Udao.selectAll());
		req.getRequestDispatcher("/views/TrangCTest.jsp").forward(req, resp);
	}

//	private void saveProfile(HttpServletRequest req, HttpServletResponse resp) {
//		String method = req.getMethod();
//		if(method.equalsIgnoreCase("POST")) {
//								
//			try {
//				Entity.User entity = new Entity.User();		
//				BeanUtils.populate(entity, req.getParameterMap());				
//				dao.update(entity);
//				req.setAttribute("message", "Lưu thành công!");
//				
//				
//			} catch (Exception e) {
//				
//				System.out.println(e);
//				req.setAttribute("message", "Lỗi Lưu!");
//			}
//		}
//	}

	public boolean  dem() {
		
		return false;
		
	}
}
