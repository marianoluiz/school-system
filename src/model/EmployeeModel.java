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
public class EmployeeModel {
    
    private Connection conn;

    public EmployeeModel(Connection conn) {
        this.conn = conn;
    }
    
    /**
	 * Adds a new employee record to the database.
	 * 
	 * @param strEmployeeId   Unique employee ID
	 * @param strLastName     Employee's last name
	 * @param strFirstName    Employee's first name
	 * @param strEmail        Employee's email address
	 * @param strGender       Employee's gender
	 * @param strCpNum        Employee's contact number
	 * @param strAddress      Employee's address
	 * @param strBday         Employee's birth date
	 * @param strStatus       Current employment status
	 * @param strDateStarted  Employment start date
	 * @param strDateResigned Employment end date or null
	 */
	public void addEmployee(String strEmployeeId, String strLastName, String strFirstName, String strEmail,
			String strGender, String strCpNum, String strAddress, String strBday, String strStatus,
			String strDateStarted, String strDateResigned) {
		try (Statement ps = conn.createStatement()) {
			ps.execute(
					"INSERT INTO finalsoop.employee(employee_id, lastname, firstname, email, gender, cp_num, address, bday, status, date_started, date_resigned) VALUES ('"
							+ strEmployeeId + "', '"
							+ strLastName + "', '"
							+ strFirstName + "', '"
							+ strEmail + "', '"
							+ strGender + "', '"
							+ strCpNum + "', '"
							+ strAddress + "', '"
							+ strBday + "', '"
							+ strStatus + "', '"
							+ strDateStarted + "', '"
							+ strDateResigned + "')");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
        
        
        /**
	 * Retrieves all employees from the database.
	 * 
	 * @return ResultSet containing employee records
	 */
	public ResultSet fetchEmployees() {
		try {
			Statement ps = conn.createStatement();
			return ps.executeQuery("SELECT * FROM finalsoop.employee");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
        
        	/**
	 * Deletes an employee record from the database.
	 * 
	 * @param strEmployeeId Employee ID to delete
	 */
	public void deleteEmployee(String strEmployeeId) {
		try (Statement ps = conn.createStatement()) {
			ps.execute("DELETE FROM finalsoop.employee WHERE employee_id = '" + strEmployeeId + "'");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
        
        /**
	 * Updates an employee record in the database.
	 * 
	 * @param strEmployeeId   Employee ID to update
	 * @param strLastName     New last name
	 * @param strFirstName    New first name
	 * @param strEmail        New email address
	 * @param strGender       New gender
	 * @param strCpNum        New contact number
	 * @param strAddress      New address
	 * @param strBday         New birth date
	 * @param strStatus       New status
	 * @param strDateStarted  New start date
	 * @param strDateResigned New resignation date
	 */
	public void updateEmployee(String strEmployeeId, String strLastName, String strFirstName, String strEmail,
			String strGender, String strCpNum, String strAddress, String strBday, String strStatus,
			String strDateStarted, String strDateResigned) {
		try (Statement ps = conn.createStatement()) {
			ps.execute("UPDATE finalsoop.employee SET lastname = '" + strLastName + "', firstname = '" + strFirstName
					+ "', email = '" + strEmail
					+ "', gender = '" + strGender + "', cp_num = '" + strCpNum + "', address = '" + strAddress
					+ "', bday = '" + strBday + "', status = '"
					+ strStatus + "', date_started = '" + strDateStarted + "', date_resigned = '" + strDateResigned
					+ "' WHERE employee_id = '" + strEmployeeId + "'");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
