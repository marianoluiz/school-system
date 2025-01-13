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
public class CollegeModel {
        
        private Connection conn;

	public CollegeModel(Connection conn) {
		this.conn = conn;
	}
        
    	/**
	 * Adds a record to the `college` table.
	 *
	 * @param strCollegeCode the college code
	 * @param strDesc        the description of the college
	 * @param strDateOpened  the date the college was opened
	 * @param strDateClosed  the date the college was closed
	 * @param strStatus      the status of the college
	 */
    
        public void addCollegeRecord(String strCollegeCode, String strDesc, String strDateOpened, String strDateClosed,
                        String strStatus) {
                Statement ps = null;
                try {
                        ps = conn.createStatement();
                        ps.execute(
                                        "INSERT INTO finalsoop.college(college_code, description, date_opened, date_closed, status) VALUES ('"
                                                        + strCollegeCode + "', '"
                                                        + strDesc + "', '"
                                                        + strDateOpened + "', '"
                                                        + strDateClosed + "', '"
                                                        + strStatus + "')");
                } catch (SQLException e) {
                        System.out.println(e);
                }
        }
        
        /**
	 * Retrieves all colleges from the database.
	 * 
	 * @return ResultSet containing college records
	 */
	public ResultSet fetchColleges() {
		try {
			Statement ps = conn.createStatement();
			return ps.executeQuery("SELECT * FROM finalsoop.college");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
        
        
        	/**
	 * Deletes a college record from the database.
	 * 
	 * @param strCollegeCode 
	 * @param strDescription 
         * @param strDateOpened 
         * @param strDateClosed  
         * @param strStatus   
	 */
	public void deleteCollege(String strCollegeCode, String strDescription, String strDateOpened, String strDateClosed, String strStatus) {
            try (Statement ps = conn.createStatement()) {
                ps.execute ("DELETE FROM finalsoop.college WHERE "
                                + "college_code = '" + strCollegeCode + 
                                "' AND description = '" + strDescription + 
                                "' AND date_opened = '" + strDateOpened + 
                                "' AND date_closed = '" + strDateClosed + 
                                "' AND status = '" + strStatus + "'"
                );
                

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error deleting record: " + e.getMessage());
            }
        }
        
        /**
	 * Updates a college record in the database.
	 * 
	 * @param strCollegeCode College code to update
	 * @param strDesc        New description
	 * @param strDateOpened  New date opened
	 * @param strDateClosed  New date closed
	 * @param strStatus      New status
	 */
        public void updateCollege(String strCollegeCode, String strDesc, String strDateOpened, String strDateClosed,
			String strStatus) {
		try (Statement ps = conn.createStatement()) {
			ps.execute("UPDATE finalsoop.college SET description = '" + strDesc + "', date_opened = '" + strDateOpened
					+ "', date_closed = '" + strDateClosed + "', status = '" + strStatus
					+ "' WHERE college_code = '" + strCollegeCode + "'");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
                
        
                
}
