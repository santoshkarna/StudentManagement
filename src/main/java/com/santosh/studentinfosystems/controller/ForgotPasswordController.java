package com.santosh.studentinfosystems.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.santosh.studentinfosystems.dto.User;
import com.santosh.studentinfosystems.service.UserService;
import com.santosh.studentinfosystems.service.UserServiceImpl;
import com.santosh.studentinfosystems.util.EmailUtil;
import com.santosh.studentinfosystems.util.ProjectUtil;

@WebServlet("/ForgotPassword")
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		User user = userService.checkEmail(email);
		if (user.getEmail() != null) {
			String newPassword = ProjectUtil.newPassword();
			EmailUtil.sendEmail(email, newPassword);
			user.setPassword(newPassword);
			userService.updateUserInfo(user);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("forGotPassword.jsp");
			request.setAttribute("emailNotFound", "Email not found!!!");
			rd.forward(request, response);
		}

	}

}
