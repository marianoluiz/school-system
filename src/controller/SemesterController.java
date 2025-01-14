/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.SemesterModel;
import view.DashboardView;

/**
 *
 * @author Mariano
 */
public class SemesterController {
    SemesterModel semesterModel = null;
    DashboardView dashboardView = null;
    
    public SemesterController(SemesterModel semesterModel, DashboardView dashboardView) {
        this.semesterModel = semesterModel;
        this.dashboardView = dashboardView;
    }
    
    
    	public ResultSet fetchSemesters() {
		try {
			return semesterModel.fetchSemesters();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
