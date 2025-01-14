/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import model.EmployeeModel;
import model.UiModel;
import view.DashboardView;

public class EmployeeController {
    
    EmployeeModel employeeModel = null;
    DashboardView dashboardView = null;
    UiModel uiModel = null;

    public EmployeeController(EmployeeModel employeeModel, DashboardView dashboardView, UiModel uiModel) {
        this.employeeModel = employeeModel;
        this.dashboardView = dashboardView;
        this.uiModel = uiModel;
    }
    
    	public ResultSet fetchEmployees() {
		try {
			return employeeModel.fetchEmployees();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
    
    public void addEmployee(JTable populatedTable, String strEmpId, String strLastName, String strFirstName, String strEmail, String strGenderCode, String strCpNo, String strAddress, String strBirthdate, String strStatus, String strDateStarted, String strDateResigned ) {
        // Adding of new employee record
        
        employeeModel.addEmployee(
                strEmpId
                , strLastName
                , strFirstName
                , strEmail
                , strGenderCode
                , strCpNo
                , strAddress
                , strBirthdate
                , strStatus
                , strDateStarted
                , strDateResigned
        );
        
        uiModel.populateTable(employeeModel.fetchEmployees(), populatedTable);
    }
    
    public void updateEmployee(JTable populatedTable, String strEmpId, String strLastName, String strFirstName, String strEmail, String strGenderCode, String strCpNo, String strAddress, String strBirthdate, String strStatus, String strDateStarted, String strDateResigned ) {
        
        employeeModel.updateEmployee( 
                strEmpId
                , strLastName
                , strFirstName
                , strEmail
                , strGenderCode
                , strCpNo
                , strAddress
                , strBirthdate
                , strStatus
                , strDateStarted
                , strDateResigned
        );

        uiModel.populateTable(employeeModel.fetchEmployees(), populatedTable);
    }
    
    public void deleteEmployee(JTable populatedTable, String strEmployeeId ) {
        
        employeeModel.deleteEmployee( 
                strEmployeeId
        );

        employeeModel.deleteEmployee(strEmployeeId);
        uiModel.populateTable(employeeModel.fetchEmployees(), populatedTable);
    }

}
