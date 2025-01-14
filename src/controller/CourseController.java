/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import model.CourseModel;
import view.DashboardView;

/**
 *
 * @author Mariano
 */
public class CourseController {
    CourseModel courseModel = null;
    DashboardView dashboardView = null;
    
    public CourseController(CourseModel courseModel, DashboardView dashboardView) {
        this.courseModel = courseModel;
        this.dashboardView = dashboardView;
    }
    
        
	public ResultSet fetchCourses() {
		try {
			return courseModel.fetchCourses();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
    
    
}
