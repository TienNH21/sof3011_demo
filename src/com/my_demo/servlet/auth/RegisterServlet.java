package com.my_demo.servlet.auth;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
//import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import com.my_demo.dao.UserDAO;
import com.my_demo.entity.User;
import com.utils.EncryptUtils;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	protected UserDAO userDAO;
    public RegisterServlet() {
        super();
        
        this.userDAO = new UserDAO();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		request.getRequestDispatcher("/views/auth/register.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> data = request.getParameterMap();
		User entity = new User();
		try {
			BeanUtils.populate(entity, request.getParameterMap());
			String hashed = EncryptUtils.hashPassword(entity.getPassword());
			entity.setPassword(hashed);
			this.userDAO.create(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
