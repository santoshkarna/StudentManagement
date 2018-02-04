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

import org.apache.log4j.Logger;

import com.santosh.studentinfosystems.dto.Student;
import com.santosh.studentinfosystems.service.StudentService;
import com.santosh.studentinfosystems.service.StudentServiceImpl;
import com.santosh.studentinfosystems.util.ImageUtil;

@WebServlet("/StudentController")
@MultipartConfig
public class StudentController extends HttpServlet {
	private static final Logger log = Logger.getLogger(StudentController.class);

	private static final long serialVersionUID = 1L;
	private static final String STUDENT_LIST_PAGE = "studentDetails.jsp";
	private static final String STUDENT_NEW_PAGE = "studentForm.jsp";
	StudentService studentService = new StudentServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("doget method of student controller called");
		String action = request.getParameter("actions");
		String forward = "";

		if (action.equals("student_new")) {
			log.info("student new called");
			forward = STUDENT_NEW_PAGE;
		}
		if (action.equals("student_edit")) {
			log.info("student edit called");
			int id = Integer.parseInt(request.getParameter("studentId"));
			request.setAttribute("student", studentService.getStudentInfoById(id));
			forward = STUDENT_NEW_PAGE;
		} else if (action.equals("student_delete")) {
			log.info("student delete called");
			int id = Integer.parseInt(request.getParameter("studentId"));
			studentService.deleteStudentInfo(id);
			request.setAttribute("students", studentService.getAllStudentInfo());
			forward = STUDENT_LIST_PAGE;
		} else if (action.equals("student_list")) {
			log.info("student list called");
			request.setAttribute("students", studentService.getAllStudentInfo());
			forward = STUDENT_LIST_PAGE;
		}

		log.info("page forwarded");
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("student controller doPost method called");
		Student student = new Student();
		log.info("Fething data from jsp");
		student.setStudentName(request.getParameter("sname"));
		student.setCollegeName(request.getParameter("cname"));
		student.setEmail(request.getParameter("email"));
		student.setRoll(Integer.parseInt(request.getParameter("roll")));
		student.setDepartments(request.getParameter("departments"));
		student.setGender(request.getParameter("gender"));

		log.info("Fething date from jsp");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			log.info("parsing date");
			Date dob = dateFormat.parse(request.getParameter("dob"));
			student.setDob(dob);
		} catch (ParseException e) {
			e.printStackTrace();
			log.error(e);
		}

		// for subject(checkbox)
		log.info("fething check boxes value");
		String[] subjects = request.getParameterValues("subject");
		String subject = "";
		for (String sub : subjects) {
			subject = subject + sub + "/";
		}
		student.setSubject(subject);

		String studentId = request.getParameter("id");

		// for image
		log.info("Fething image from jsp");
		Part part = request.getPart("photo");
		String fileName = ImageUtil.getFileName(part);
		String imageUrl = "";
		if (!fileName.isEmpty()) {
			log.info("Fething image from jsp while new ");
			imageUrl = ImageUtil.writeImageToFile(imageUrl + fileName, part);
		} else {
			log.info("Fething image from jsp while edit ");
			imageUrl = studentService.getImageUrl(Integer.parseInt(studentId));
		}
		student.setImageUrl(imageUrl);

		if (studentId == null || studentId.isEmpty()) {
			studentService.saveStudentInfo(student);
			log.info("student info saved ");
		} else {
			student.setId(Integer.parseInt(studentId));
			studentService.updateStudentInfo(student);
			log.info("student info updated ");
		}

		log.info("page forwarded to list page after save or update ");
		RequestDispatcher rd = request.getRequestDispatcher(STUDENT_LIST_PAGE);
		request.setAttribute("students", studentService.getAllStudentInfo());
		rd.forward(request, response);
	}

}
