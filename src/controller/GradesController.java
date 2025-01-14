/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.GradesModel;
import view.DashboardView;

/**
 *
 * @author Mariano
 */
public class GradesController {
    GradesModel gradesModel = null;
    DashboardView dashboardView = null;
    
    public GradesController(GradesModel gradesModel, DashboardView dashboardView) {
        this.gradesModel = gradesModel;
        this.dashboardView = dashboardView;
    }
    
    	public ResultSet fetchGrades() {
		try {
			return gradesModel.fetchGrades();
		} catch (Exception e) {
			System.out.println(e);
                        return null;
		}
		
	}
}
