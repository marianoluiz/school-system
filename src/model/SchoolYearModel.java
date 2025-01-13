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
public class SchoolYearModel {
    
    private Connection conn;

    public SchoolYearModel(Connection conn) {
        this.conn = conn;
    }
    
    /**
	 * Adds a new school year record to the database.
	 * 
	 * @param strYear The school year to add (e.g. "2023-2024")
	 */
	public void addSchoolYear(String strYear) {
		try (Statement ps = conn.createStatement()) {
			ps.execute("INSERT INTO finalsoop.schoolyear(syear) VALUES ('" + strYear + "')");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
        
        /**
	 * Retrieves all school years from the database.
	 * 
	 * @return ResultSet containing school year records
	 */
	public ResultSet fetchSchoolYears() {
		try {
			Statement ps = conn.createStatement();
			return ps.executeQuery("SELECT * FROM finalsoop.schoolyear");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
        
        /**
	 * Deletes a school year record from the database.
	 * 
	 * @param strSyear School year to delete
	 */
	public void deleteSchoolYear(String strSyear) {
		try (Statement ps = conn.createStatement()) {
			ps.execute("DELETE FROM finalsoop.schoolyear WHERE syear = '" + strSyear + "'");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
        
        	/**
	 * Updates a school year record in the database.
	 * 
	 * @param strSyear    Current school year to update
	 * @param strNewSyear New school year value
	 */
	public void updateSchoolYear(String strSyear, String strNewSyear) {
		try (Statement ps = conn.createStatement()) {
			ps.execute(
					"UPDATE finalsoop.schoolyear SET syear = '" + strNewSyear + "' WHERE syear = '" + strSyear + "'");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
