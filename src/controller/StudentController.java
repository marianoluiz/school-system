/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.StudentModel;
import view.DashboardView;

/**
 *
 * @author Mariano
 */
public class StudentController {
    
    StudentModel studentModel = null;
    DashboardView dashboardView = null;

    public StudentController(StudentModel studentModel, DashboardView dashboardView) {
        this.studentModel = studentModel;
        this.dashboardView = dashboardView;
    }

    public ResultSet fetchStudents() {
            try {
                return studentModel.fetchStudents();
            } catch (Exception e) {
                System.out.println(e);
                throw new RuntimeException("Failed to fetch students", e);
            }

    }
    
    
    public void btnDeleteStudent(JTable Table) throws Exception{
        int row = Table.getSelectedRow();
        String studentNumber = Table.getModel().getValueAt(row, 0).toString();

        studentModel.deleteStudent(studentNumber);
     }
    
    public void btnAddStudent (JTextField StudentNo, 
             JTextField LastName, 
             JTextField FirstName, 
             JTextField Email, 
             JComboBox Gender, 
             JComboBox CourseCode, 
             JTextField CpNumber, 
             JTextField Address, 
             JTextField Birthday, 
             JComboBox Status, 
             JTextField DateStarted, 
             JTextField DateGraduated) throws Exception 
    {
         transformComboBoxes(Gender, Status);
         studentModel.addStudent(StudentNo.getText().trim(), 
                 LastName.getText().trim(), 
                 FirstName.getText(), 
                 Email.getText(), 
                 genderTransformed, 
                 "(SELECT course_code FROM finalsoop.course WHERE description = '" + CourseCode.getSelectedItem().toString().trim() + "')", 
                 CpNumber.getText().trim(), 
                 Address.getText().trim(), 
                 Birthday.getText().trim(), 
                 statusTransformed, 
                 DateStarted.getText().trim(), 
                 DateGraduated.getText().trim());
         
     }
    
    
    public void btnUpdateStudent(JTextField StudentNo, 
             JTextField LastName, 
             JTextField FirstName, 
             JTextField Email, 
             JComboBox Gender, 
             JComboBox CourseCode, 
             JTextField CpNumber, 
             JTextField Address, 
             JTextField Birthday, 
             JComboBox Status, 
             JTextField DateStarted, 
             JTextField DateGraduated) throws Exception{
        

         
        //basically, i want transform the values of the combo boxes into a format accepted by the query before running the query
        transformComboBoxes(Gender, Status);
        studentModel.updateStudent(cachedStudentNo, 
                StudentNo.getText().trim(), 
                LastName.getText().trim(), 
                FirstName.getText(), 
                Email.getText(), 
                genderTransformed, 
                "(SELECT course_code FROM finalsoop.course WHERE description = '" + CourseCode.getSelectedItem().toString().trim() + "')", 
                CpNumber.getText().trim(), 
                Address.getText().trim(), 
                Birthday.getText().trim(), 
                statusTransformed, 
                DateStarted.getText().trim(), 
                DateGraduated.getText().trim());
        
         System.out.println("cpnum: " + CpNumber.getText());

     }

}
