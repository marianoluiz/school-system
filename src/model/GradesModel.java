/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Mariano
 */
public class GradesModel {
    
    private Connection conn;

    public GradesModel(Connection conn) {
        this.conn = conn;
    }
    
    /**
	 * Records a student's grade for a subject.
	 * 
	 * @param strSyear       School year
	 * @param strSemester    Semester period
	 * @param strStudentNo   Student number
	 * @param strSubjectCode Subject code
	 * @param strBlockNo     Block/section number
	 * @param dblGrade       Numerical grade
	 */
	public void addGrade(String strSyear, String strSemester, String strStudentNo, String strSubjectCode,
			String strBlockNo, double dblGrade) {
		try (Statement ps = conn.createStatement()) {
			ps.execute(
					"INSERT INTO finalsoop.grades(syear, semester, student_no, subject_code, block_no, grade) VALUES ('"
							+ strSyear + "', '"
							+ strSemester + "', "
							+ strStudentNo + ", "
							+ strSubjectCode + ", '"
							+ strBlockNo + "', "
							+ dblGrade + ")");
		} catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Adding grade failed");    
			System.out.println(e);
		}
	}
        
        /**
	 * Retrieves all grades from the database.
	 * 
	 * @return ResultSet containing grade records
	 */
	public ResultSet fetchGrades() {
		try {
			Statement ps = conn.createStatement();
			return ps.executeQuery("SELECT * FROM finalsoop.student_grades_view");
		} catch (SQLException e) {
			System.out.println(e);
                        return null;
		}
	}
        
        public void deleteGrade(String strSyear, String strSemester, String strStudentNo, String strSubjectCode) {
		try (Statement ps = conn.createStatement()) {
			ps.execute("DELETE FROM finalsoop.grades WHERE syear = '" + strSyear + "' AND semester = '" + strSemester
					+ "' AND student_no = '"
					+ strStudentNo + "' AND subject_code = '" + strSubjectCode + "'");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
        
        
	/**
	 * Updates a grade record in the database.
	 * 
	 * @param strSyear       School year of the grade
	 * @param strSemester    Semester of the grade
	 * @param strStudentNo   Student number
	 * @param strSubjectCode Subject code
	 * @param strBlockNo     Block number
	 * @param dblGrade       New grade value
	 */
	public void updateGrade(String strSyear, String strSemester, String strStudentNo, String strSubjectCode,
			String strBlockNo, double dblGrade) {
		try (Statement ps = conn.createStatement()) {
			ps.execute("UPDATE finalsoop.grades SET grade = " + dblGrade + " WHERE syear = '" + strSyear
					+ "' AND semester = '" + strSemester
					+ "' AND student_no = '" + strStudentNo + "' AND subject_code = '" + strSubjectCode
					+ "' AND block_no = '" + strBlockNo + "'");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}


