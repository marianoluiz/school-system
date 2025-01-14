package main;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.*;
import javax.swing.*;
import view.*;
import model.*;
import controller.*;

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
        
      
        // Passing model and view to Controller
        BuildingController buildingController = new BuildingController(buildingModel, dashboardView);
        CollegeController collegeController = new CollegeController(collegeModel, dashboardView);
        CourseController courseController = new CourseController(courseModel, dashboardView);
        EmployeeController employeeController = new EmployeeController(employeeModel, dashboardView, uiModel);
        GradesController gradesController = new GradesController(gradesModel, dashboardView);
        SchoolYearController schoolYearController = new SchoolYearController(schoolYearModel, dashboardView);
        SemesterController semesterController = new SemesterController(semesterModel, dashboardView);
        StudentController studentController = new StudentController(studentModel, dashboardView);
        SubjectController subjectController = new SubjectController(subjectModel, dashboardView);
        SubjectScheduleController subjectScheduleController = new SubjectScheduleController(subjectScheduleModel, dashboardView);
        UiController uiController = new UiController(uiModel, dashboardView, courseController);
       
        // Passing controller to view
        dashboardView.setControllers(
            buildingController,
            collegeController,
            courseController,
            employeeController,
            gradesController,
            schoolYearController,
            semesterController,
            studentController,
            subjectController,
            subjectScheduleController,
            uiController
        );
                
        dashboardView.setVisible(true);
    }
}