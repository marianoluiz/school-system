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
public class SemesterModel {
    
    private Connection conn;

    public SemesterModel(Connection conn) {
        this.conn = conn;
    }
    	/**
	 * Adds a new school year record to the database.
	 * 
	 * @param strYear The school year to add (e.g. "2023-2024")
	 */
	public void addSemester(String strSemester) {
		try (Statement ps = conn.createStatement()) {
			ps.execute("INSERT INTO finalsoop.semester(semester) VALUES ('" + strSemester + "')");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
        
        /**
	 * Retrieves all semesters from the database.
	 * 
	 * @return ResultSet containing semester records
	 */
	public ResultSet fetchSemesters() {
		try {
			Statement ps = conn.createStatement();
			return ps.executeQuery("SELECT * FROM finalsoop.semester");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
        
        /**
	 * Deletes a semester record from the database.
	 * 
	 * @param strSemester Semester to delete
	 */
	public void deleteSemester(String strSemester) {
		try (Statement ps = conn.createStatement()) {
			ps.execute("DELETE FROM finalsoop.semester WHERE semester = '" + strSemester + "'");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
        
        	/**
	 * Updates a semester record in the database.
	 * 
	 * @param strSemester    Current semester to update
	 * @param strNewSemester New semester value
	 */
	public void updateSemester(String strSemester, String strNewSemester) {
		try (Statement ps = conn.createStatement()) {
			ps.execute("UPDATE finalsoop.semester SET semester = '" + strNewSemester + "' WHERE semester = '"
					+ strSemester + "'");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
