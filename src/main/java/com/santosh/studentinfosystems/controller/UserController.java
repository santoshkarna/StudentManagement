package com.santosh.studentinfosystems.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.santosh.studentinfosystems.dto.User;
import com.santosh.studentinfosystems.service.UserService;
import com.santosh.studentinfosystems.service.UserServiceImpl;
import com.santosh.studentinfosystems.util.ImageUtil;

@WebServlet("/UserController")
@MultipartConfig
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String USER_LIST_PAGE = "userDetails.jsp";
	private static final String USER_NEW_PAGE = "userForm.jsp";
	UserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("actions");
		String forward = "";
		if (action.equals("user_new")) {
			forward = USER_NEW_PAGE;
		} else if (action.equals("user_edit")) {
			int id = Integer.parseInt(request.getParameter("userId"));
			request.setAttribute("user", userService.getUserInfoById(id));
			forward = USER_NEW_PAGE;
		} else if (action.equals("user_delete")) {
			int id = Integer.parseInt(request.getParameter("userId"));
			userService.deleteUserInfo(id);
			request.setAttribute("users", userService.getAllUserInfo());
			forward = USER_LIST_PAGE;
		} else if (action.equals("user_list")) {
			request.setAttribute("users", userService.getAllUserInfo());
			forward = USER_LIST_PAGE;
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		user.setFirstName(request.getParameter("fname"));
		user.setLastName(request.getParameter("lname"));
		user.setEmail(request.getParameter("email"));
		user.setUserName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setGender(request.getParameter("gender"));

		// for date
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dob = dateFormat.parse(request.getParameter("dob"));
			user.setDob(dob);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		String userId = request.getParameter("id");
		// for image
		Part part = request.getPart("photo");
		String fileName = ImageUtil.getFileName(part);
		String imageUrl = "";
		if (!fileName.isEmpty()) {
			imageUrl = ImageUtil.writeImageToFile(imageUrl + fileName, part);
		} else {
			imageUrl = userService.getImageUrl(Integer.parseInt(userId));
		}
		user.setImageUrl(imageUrl);

		if (userId == null || userId.isEmpty()) {
			userService.saveUserInfo(user);
		} else {
			user.setId(Integer.parseInt(userId));
			userService.updateUserInfo(user);
		}

		RequestDispatcher rd = request.getRequestDispatcher(USER_LIST_PAGE);
		request.setAttribute("users", userService.getAllUserInfo());
		rd.forward(request, response);

	}

}
