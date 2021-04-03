package com.my_demo.servlet.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my_demo.dao.UserDAO;
import com.my_demo.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected UserDAO userDAO;

    public LoginServlet() {
        super();
        this.userDAO = new UserDAO();
    }


	protected void doGet(
		HttpServletRequest request, 
		HttpServletResponse response
	) throws ServletException, IOException {
		request.getRequestDispatcher("/views/auth/login.jsp")
			.forward(request, response);
	}

	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pwd = request.getParameter("password");
		User login = this.userDAO.login(email, pwd);
		if (login != null) {
			request.getSession().setAttribute("user", login);
			response.sendRedirect("/my_demo_2/admin/dashboard");
		} else {
			System.out.println("-----");
			doGet(request, response);
		}
		
	}

}
