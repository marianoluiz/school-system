package main;
import com.formdev.flatlaf.FlatLightLaf;
import controller.EmployeeController;
import controller.EntityController;
import java.sql.*;
import javax.swing.*;
import model.DBConnection;
import view.DashboardView;
import model.*;

public class Main {
    
 public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf");
            ex.printStackTrace();
        }
        
        Connection conn = new DBConnection().Connect();
        
        // Model
        BuildingModel buildingModel = new BuildingModel(conn);
        CollegeModel collegeModel = new CollegeModel(conn);
        CourseModel courseModel = new CourseModel(conn);
        EmployeeModel employeeModel = new EmployeeModel(conn);
        GradesModel gradesModel = new GradesModel(conn);
        SchoolYearModel schoolYearModel = new SchoolYearModel(conn);
        SemesterModel semesterModel = new SemesterModel(conn);
        StudentModel studentModel = new StudentModel(conn);
        SubjectModel subjectModel = new SubjectModel(conn);
        SubjectScheduleModel subjectScheduleModel = new SubjectScheduleModel(conn);
        UiModel uiModel = new UiModel();

        // View
        DashboardView dashboardView = new DashboardView();
        
      
        // Controller
        EntityController entityController = new EntityController( dashboardView, entityModel);        
        EmployeeController employeeController = new EmployeeController(entityModel);
       
        // Passing controller
        dashboardView.setEntityController(entityController);
        dashboardView.setEmployeeController(employeeController);
                
        dashboardView.setVisible(true);
    }
}