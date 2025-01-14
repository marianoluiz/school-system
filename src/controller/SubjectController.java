/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import model.SubjectModel;
import view.DashboardView;

/**
 *
 * @author Mariano
 */
public class SubjectController {
    SubjectModel subjectModel = null;
    DashboardView dashboardView = null;

    public SubjectController(SubjectModel subjectModel, DashboardView dashboardView) {
        this.subjectModel = subjectModel;
        this.dashboardView = dashboardView;
    }
    
    	public ResultSet fetchSubjects() {
		try {
			return subjectModel.fetchSubjects();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
