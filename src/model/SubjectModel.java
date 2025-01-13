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
public class SubjectModel {
   
        private Connection conn;

        public SubjectModel(Connection conn) {
            this.conn = conn;
        }
        
    	/**
	 * Adds a new subject to the curriculum.
	 * 
	 * @param strSubjectCode Unique subject identifier
	 * @param strDescription Subject name/description
	 * @param intUnits       Number of units for the subject
	 * @param strCurriculum  Curriculum version
	 * @param strCollegeCode College offering the subject
	 * @param strStatus      Subject status (Active/Inactive)
	 * @param strDateOpened  Date subject was introduced
	 * @param strDateClosed  Date subject was discontinued
	 */
	public void addSubject(String strSubjectCode, String strDescription, int intUnits, String strCurriculum,
			String strCollegeCode, String strStatus, String strDateOpened, String strDateClosed) {
		try (Statement ps = conn.createStatement()) {
			ps.execute(
					"INSERT INTO finalsoop.subject(subject_code, description, units, curriculum, college_code, status, date_opened, date_closed) VALUES ('"
							+ strSubjectCode + "', '"
							+ strDescription + "', "
							+ intUnits + ", '"
							+ strCurriculum + "', '"
							+ strCollegeCode + "', '"
							+ strStatus + "', '"
							+ strDateOpened + "', '"
							+ strDateClosed + "')");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
        
        	/**
	 * Retrieves all subjects from the database.
	 * 
	 * @return ResultSet containing subject records
	 */
	public ResultSet fetchSubjects() {
		try {
			Statement ps = conn.createStatement();
			return ps.executeQuery("SELECT * FROM finalsoop.subject");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
        
        /**
	 * Deletes a subject record from the database.
	 * 
	 * @param strSubjectCode Subject code to delete
	 */
	public void deleteSubject(String strSubjectCode) {
		try (Statement ps = conn.createStatement()) {
			ps.execute("DELETE FROM finalsoop.subject WHERE subject_code = '" + strSubjectCode + "'");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
        
        	/**
	 * Updates a subject record in the database.
	 * 
	 * @param strSubjectCode Subject code to update
	 * @param strDescription New description
	 * @param intUnits       New number of units
	 * @param strCurriculum  New curriculum
	 * @param strCollegeCode New college code
	 * @param strStatus      New status
	 * @param strDateOpened  New date opened
	 * @param strDateClosed  New date closed
	 */
	public void updateSubject(String strSubjectCode, String strDescription, int intUnits, String strCurriculum,
			String strCollegeCode, String strStatus, String strDateOpened, String strDateClosed) {
		try (Statement ps = conn.createStatement()) {
			ps.execute("UPDATE finalsoop.subject SET description = '" + strDescription + "', units = " + intUnits
					+ ", curriculum = '" + strCurriculum
					+ "', college_code = '" + strCollegeCode + "', status = '" + strStatus + "', date_opened = '"
					+ strDateOpened + "', date_closed = '" + strDateClosed
					+ "' WHERE subject_code = '" + strSubjectCode + "'");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
        
        
        
}
