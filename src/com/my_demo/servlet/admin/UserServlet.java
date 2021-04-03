package com.my_demo.servlet.admin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.my_demo.dao.UserDAO;
import com.my_demo.entity.User;

@WebServlet({
	"/admin/users",
	"/admin/users/edit",
	"/admin/users/update",
	"/admin/users/delete",
})
public class UserServlet extends HttpServlet {
	private UserDAO userDAO;
       
    public UserServlet() {
        super();
        
        this.userDAO = new UserDAO();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("edit")) {
			this.edit(request, response);
		} else if (uri.contains("create")) {
			//
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		} else {
			this.index(request, response);
		}
	}
	
	private void index (
			HttpServletRequest request,
			HttpServletResponse response
		) throws ServletException, IOException {
		int limit = 10, offset = 0;
		List<User> listUser = this.userDAO.paginate(limit, offset);
		request.setAttribute("listUser", listUser);
		request.getRequestDispatcher("/views/admin/users/index.jsp")
			.forward(request, response);
	}
	
	private void edit (
			HttpServletRequest request,
			HttpServletResponse response
		) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User entity = this.userDAO.find(id);
		request.setAttribute("user", entity);
		request.getRequestDispatcher("/views/admin/users/edit.jsp")
			.forward(request, response);
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("update")) {
			this.update(request, response);
		} else {
			// 404
//			this.index(request, response);
		}
	}
	
	private void update (
			HttpServletRequest request,
			HttpServletResponse response
		) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User entity = this.userDAO.find(id);
		try {
			BeanUtils.populate(entity, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.userDAO.update(entity);
		response.sendRedirect(request.getContextPath() + "/admin/users");
	}
	
	private void delete (
			HttpServletRequest request,
			HttpServletResponse response
		) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = new User();
		user.setId(id);
		this.userDAO.delete(user);
		response.sendRedirect(request.getContextPath() + "/admin/users");
	}

}
