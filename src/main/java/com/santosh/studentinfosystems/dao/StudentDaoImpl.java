package com.santosh.studentinfosystems.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.santosh.studentinfosystems.dto.Student;
import com.santosh.studentinfosystems.util.DbUtil;

public class StudentDaoImpl implements StudentDao {
	PreparedStatement ps = null;

	@Override
	public void saveStudentInfo(Student student) {
		String sql = "insert into student_details(student_name, college_name, email, subject,departments,gender, roll, dob,image_url)values(?,?,?,?,?,?,?,?,?)";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getCollegeName());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getSubject());
			ps.setString(5, student.getDepartments());
			ps.setString(6, student.getGender());
			ps.setInt(7, student.getRoll());
			ps.setDate(8, new java.sql.Date(student.getDob().getTime()));
			ps.setString(9, student.getImageUrl());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateStudentInfo(Student student) {
		String sql = "update student_details set student_name=?, college_name=?, email=?, subject=?,departments=?,gender=?, roll=?, dob=?, image_url=? where id=?";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getCollegeName());
			ps.setString(3, student.getEmail());
			ps.setString(4, student.getSubject());
			ps.setString(5, student.getDepartments());
			ps.setString(6, student.getGender());
			ps.setInt(7, student.getRoll());
			ps.setDate(8, new java.sql.Date(student.getDob().getTime()));
			ps.setString(9, student.getImageUrl());
			ps.setInt(10, student.getId());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStudentInfo(int id) {
		String sql = "delete from student_details where id=?";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Student> getAllStudentInfo() {
		List<Student> studentList = new ArrayList<>();
		String sql = "select * from student_details";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setStudentName(rs.getString("student_name"));
				student.setCollegeName(rs.getString("college_name"));
				student.setEmail(rs.getString("email"));
				student.setGender(rs.getString("gender"));
				student.setDepartments(rs.getString("departments"));
				student.setSubject(rs.getString("subject"));
				student.setDob(rs.getDate("dob"));
				student.setRoll(rs.getInt("roll"));
				studentList.add(student);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public Student getStudentInfoById(int id) {
		Student student = new Student();
		String sql = "select * from student_details where id=?";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				student.setId(rs.getInt("id"));
				student.setStudentName(rs.getString("student_name"));
				student.setCollegeName(rs.getString("college_name"));
				student.setEmail(rs.getString("email"));
				student.setGender(rs.getString("gender"));
				student.setDepartments(rs.getString("departments"));
				student.setSubject(rs.getString("subject"));
				student.setDob(rs.getDate("dob"));
				student.setRoll(rs.getInt("roll"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String getImageUrl(int id) {
		String sql = "select image_url from student_details where id=?";
		String imageUrl = "";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				imageUrl = rs.getString("image_url");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return imageUrl;
	}

}
