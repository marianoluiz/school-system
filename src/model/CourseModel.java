/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mariano
 */
public class CourseModel {
    
        private Connection conn;

	public CourseModel(Connection conn) {
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
	public void addCourse(String strCourseCode, String strDescription, String strCollegeCode, String strDateOpened,
			String strDateClosed, String strStatus) {
		try (Statement ps = conn.createStatement()) {
			ps.execute(
					"INSERT INTO finalsoop.course(course_code, description, college_code, date_opened, date_closed, status) VALUES ('"
							+ strCourseCode + "', '"
							+ strDescription + "', '"
							+ strCollegeCode + "', '"
							+ strDateOpened + "', '"
							+ strDateClosed + "', '"
							+ strStatus + "')");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
        
        /**
	 * Retrieves all courses from the database.
	 * 
	 * @return ResultSet containing course records
	 */
	public ResultSet fetchCourses() {
		try {
			Statement ps = conn.createStatement();
			return ps.executeQuery("SELECT * FROM finalsoop.course");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
        
        /**
	 * Deletes a course record from the database.
	 * 
	 * @param strCourseCode Course code to delete
	 */
	public void deleteCourse(String strCourseCode) {
		try (Statement ps = conn.createStatement()) {
			ps.execute("DELETE FROM finalsoop.course WHERE course_code = '" + strCourseCode + "'");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
        
        
        	/**
	 * Updates a course record in the database.
	 * 
	 * @param strCourseCode  Course code to update
	 * @param strDescription New course description
	 * @param strCollegeCode New college code
	 * @param strDateOpened  New date opened
	 * @param strDateClosed  New date closed
	 * @param strStatus      New status
	 */
	public void updateCourse(String strCourseCode, String strDescription, String strCollegeCode, String strDateOpened,
			String strDateClosed, String strStatus) {
		try (Statement ps = conn.createStatement()) {
			ps.execute("UPDATE finalsoop.course SET description = '" + strDescription + "', college_code = '"
					+ strCollegeCode
					+ "', date_opened = '" + strDateOpened + "', date_closed = '" + strDateClosed + "', status = '"
					+ strStatus
					+ "' WHERE course_code = '" + strCourseCode + "'");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
