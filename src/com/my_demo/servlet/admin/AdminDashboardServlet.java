package com.my_demo.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my_demo.entity.User;

@WebServlet("/admin/dashboard")
public class AdminDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminDashboardServlet() {
        super();
    }

	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		request.getRequestDispatcher("/views/admin/dashboard.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}}
