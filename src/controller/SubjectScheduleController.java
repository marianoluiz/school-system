/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import model.SubjectScheduleModel;
import view.DashboardView;

/**
 *
 * @author Mariano
 */
public class SubjectScheduleController {
    SubjectScheduleModel subjectScheduleModel = null;
    DashboardView dashboardView = null;

    public SubjectScheduleController(SubjectScheduleModel subjectScheduleModel, DashboardView dashboardView) {
        this.subjectScheduleModel = subjectScheduleModel;
        this.dashboardView = dashboardView;
    }
    
    	public ResultSet fetchSubjectSchedules() {
		try {
			return subjectScheduleModel.fetchSubjectSchedules();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
    
}
