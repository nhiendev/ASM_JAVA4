package UX;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import DAO.VideoDAO;
import Entity.Video;
@MultipartConfig
@WebServlet({ "/editVideo/*", "/user/createVideo", "/user/deleteVideo/*", "/user/updateVideo"})
public class editVideo extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
	
		if (uri.contains("editVideo")) {
			editVD(req,resp);
		}
		else if (uri.contains("createVideo")) {
			try {
				File dir = new File(req.getServletContext().getRealPath("/img/files"));
				if (!dir.exists()) { // tạo nếu chưa tồn tại
					dir.mkdirs();
				}
		
				Part photo = req.getPart("poster"); // file hình
				System.out.println("Đường Dẫn ảnh: " + photo.getName());
				File photoFile = new File(dir, photo.getSubmittedFileName());
				photo.write(photoFile.getAbsolutePath());
				
				
				BeanUtils.populate(vdeo, req.getParameterMap());
				vdeo.setPoster(String.valueOf(photo));
				System.out.println(vdeo.getDescription());
				Vdao.insert(vdeo);
				req.setAttribute("message", "Tạo thành công");
			
			} catch (Exception e) {
				System.out.println(e);
				req.setAttribute("message", "them thất bại");
			}
			req.setAttribute("view", "/views/QLVideo.jsp");
		} 
		
		
		else if(uri.contains("deleteVideo")) {
		//	String uri = req.getRequestURI();
//			String id = uri.substring(uri.lastIndexOf("/") + 1);

			try {
				
				Vdao.delete(id);
				req.setAttribute("messageVideo", "Xóa thành công");
				req.setAttribute("view", "/views/QLVideo.jsp");
			} catch (Exception e) {				
				System.out.println(e);
				req.setAttribute("view", "/views/QLVideo.jsp");			
				req.setAttribute("message", "Xóa thất bại");
			}
			
			
		}else if (uri.contains("updateVideo")) {
			try {
				BeanUtils.populate(vdeo, req.getParameterMap());
				Vdao.update(vdeo);
				req.setAttribute("message", "Cập nhật thành công");				
			} catch (Exception e) {
				System.out.println(e);
				req.setAttribute("message", "Cập nhật thất bại");
			}
			req.setAttribute("view", "/views/QLVideo.jsp");
		} 
		req.setAttribute("videoALL", Vdao.selectAll());
		req.setAttribute("form", vdeo);
		req.getRequestDispatcher("/views/TrangCTest.jsp").forward(req, resp);
	}
	
	Video vdeo = new Video();
	VideoDAO Vdao = new VideoDAO();
	
	private void editVD(HttpServletRequest req, HttpServletResponse resp) {
		String uri = req.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/") + 1);
		vdeo.setId(id);

		vdeo = Vdao.selectById(vdeo.getId());		
		req.setAttribute("view", "/views/QLVideo.jsp");
	}
	

}
