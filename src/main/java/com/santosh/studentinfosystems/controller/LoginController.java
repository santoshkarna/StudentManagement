package com.santosh.studentinfosystems.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.santosh.studentinfosystems.service.UserService;
import com.santosh.studentinfosystems.service.UserServiceImpl;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		request.setAttribute("logOutMsg", "You are successfully logged out!!!");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("uname");
		String password = request.getParameter("pass");
		String rememberMe = request.getParameter("remember-me");
		int isUser = userService.checkUser(userName, password);
		if (isUser > 0) {
			if (rememberMe != null) {
				Cookie cookie1 = new Cookie("uname", userName);
				Cookie cookie2 = new Cookie("pass", password);
				cookie1.setMaxAge(24 * 60 * 60);
				cookie2.setMaxAge(24 * 60 * 60);
				response.addCookie(cookie1);
				response.addCookie(cookie2);
			}
			HttpSession session = request.getSession();
			session.setAttribute("username", userName);
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("loginFailMsg", "Wrong username or password!!!");
			rd.include(request, response);
		}

	}

}
