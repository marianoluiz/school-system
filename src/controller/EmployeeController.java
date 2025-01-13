/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JTable;
import model.EntityModel;

public class EmployeeController {
    
    EntityModel entityModel;
    
    public EmployeeController(EntityModel entityModel) {
        this.entityModel = entityModel;
    }
    
    public void addEmployee(JTable populatedTable, String strEmpId, String strLastName, String strFirstName, String strEmail, String strGenderCode, String strCpNo, String strAddress, String strBirthdate, String strStatus, String strDateStarted, String strDateResigned ) {
        // Adding of new employee record
        
        entityModel.addEmployee(
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
        
        entityModel.populateTable(entityModel.fetchEmployees(), populatedTable);
    }
    
    public void updateEmployee(JTable populatedTable, String strEmpId, String strLastName, String strFirstName, String strEmail, String strGenderCode, String strCpNo, String strAddress, String strBirthdate, String strStatus, String strDateStarted, String strDateResigned ) {
        
        entityModel.updateEmployee( 
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

        entityModel.populateTable(entityModel.fetchEmployees(), populatedTable);
    }
    
    public void deleteEmployee(JTable populatedTable, String strEmployeeId ) {
        
        entityModel.deleteEmployee( 
                strEmployeeId
        );

        entityModel.deleteEmployee(strEmployeeId);
        entityModel.populateTable(entityModel.fetchEmployees(), populatedTable);
    }

}
