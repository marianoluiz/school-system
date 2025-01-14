/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.SchoolYearModel;
import view.DashboardView;

/**
 *
 * @author Mariano
 */
public class SchoolYearController {
    SchoolYearModel schoolYearModel = null;
    DashboardView dashboardView = null;
    
    public SchoolYearController(SchoolYearModel schoolYearModel, DashboardView dashboardView) {
        this.schoolYearModel = schoolYearModel;
        this.dashboardView = dashboardView;
    }
    
    
    	public ResultSet fetchSchoolYears() {
		try {
			return schoolYearModel.fetchSchoolYears();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
        
        
}
