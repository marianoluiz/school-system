/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Mariano
 */
public class StudentModel {
    
    private Connection conn;

    public StudentModel(Connection conn) {
        this.conn = conn;
    }
    
    /**
	 * Adds a new course record to the database.
	 * 
	 * @param strCourseCode  Unique identifier for the course
	 * @param strDescription Course name/description
	 * @param strCollegeCode Foreign key reference to college table
	 * @param strDateOpened  Date when course was opened
	 * @param strDateClosed  Date when course was closed/discontinued
	 * @param strStatus      Current status of the course (e.g. "Active",
	 *                       "Inactive")
	 */
	public void addStudent(String strStudentNo, String strLastName, String strFirstName, String strEmail,
			String strGender, String strCourseCode, String strCpNum, String strAddress, String strBday,
			String strStatus, String strDateStarted, String strDateGraduated) {
		try (Statement ps = conn.createStatement()) {
			ps.execute(
					"INSERT INTO finalsoop.student(student_no, lastname, firstname, email, gender, course_code, cp_num, address, bday, status, date_started, date_graduated) VALUES ('"
							+ strStudentNo + "', '"
							+ strLastName + "', '"
							+ strFirstName + "', '"
							+ strEmail + "', '"
							+ strGender + "', "
							+ strCourseCode + ", '"
							+ strCpNum + "', '"
							+ strAddress + "', '"
							+ strBday + "', '"
							+ strStatus + "', '"
							+ strDateStarted + "', '"
							+ strDateGraduated + "')");
		} catch (SQLException e) {
			System.out.println(e);
                        JOptionPane.showMessageDialog(null, "Adding of student failed");
		}
	}
        
        /**
	 * Retrieves all students from the database.
	 * 
	 * @return ResultSet containing student records
	 */
	public ResultSet fetchStudents() {
		try {
			Statement ps = conn.createStatement();
			return ps.executeQuery("SELECT * FROM finalsoop.student");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
        
        
	/**
	 * Deletes a student record from the database.
	 * 
	 * @param strStudentNo Student number to delete
	 */
	public void deleteStudent(String strStudentNo) {
		try (Statement ps = conn.createStatement()) {
			ps.execute("DELETE FROM finalsoop.student WHERE student_no = '" + strStudentNo + "'");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
        
        	/**
	 * Updates a student record in the database.
	 * 
	 * @param strStudentNo     Student number to update
	 * @param strLastName      New last name
	 * @param strFirstName     New first name
	 * @param strEmail         New email address
	 * @param strGender        New gender
	 * @param strCourseCode    New course code
	 * @param strCpNum         New contact number
	 * @param strAddress       New address
	 * @param strBday          New birth date
	 * @param strStatus        New status
	 * @param strDateStarted   New start date
	 * @param strDateGraduated New graduation date
	 */
	public void updateStudent(String oldStudentNo, String strStudentNo, String strLastName, String strFirstName, String strEmail,
			String strGender, String strCourseCode, String strCpNum, String strAddress, String strBday,
			String strStatus, String strDateStarted, String strDateGraduated) {
                        
		try (Statement ps = conn.createStatement()) {
			ps.execute("UPDATE finalsoop.student SET lastname = '" + strLastName + "', firstname = '" + strFirstName
					+ "', email = '" + strEmail
					+ "', gender = '" + strGender + "', course_code = " + strCourseCode + ", cp_num = '" + strCpNum
					+ "', address = '" + strAddress
					+ "', bday = '" + strBday + "', status = '" + strStatus + "', date_started = '" + strDateStarted
					+ "', date_graduated = '" + strDateGraduated
					+ "' WHERE student_no = '" + oldStudentNo + "'");
		} catch (SQLException e) {
			System.out.println(e);
                        JOptionPane.showMessageDialog(null, "Adding of student failed");
		}
	}
}
