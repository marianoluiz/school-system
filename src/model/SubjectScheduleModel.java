/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mariano
 */
public class SubjectScheduleModel {
    
    private Connection conn;

    public SubjectScheduleModel(Connection conn) {
        this.conn = conn;
    }
        
    /**
	 * Creates a new subject schedule entry.
	 * 
	 * @param strSyear       School year
	 * @param strSemester    Semester period
	 * @param strCollegeCode College offering the subject
	 * @param strBlockNo     Block/section number
	 * @param strSubjectCode Subject identifier
	 * @param strDay         Day(s) of the week
	 * @param strTime        Time slot
	 * @param strRoom        Room assignment
	 * @param strType        Class type (Lecture/Laboratory)
	 * @param intSequenceNo  Sequence number
	 * @param strEmployeeId  Assigned faculty
	 */
	public void addSubjectSchedule(String strSyear, String strSemester, String strCollegeCode, String strBlockNo,
			String strSubjectCode, String strDay, String strTime, String strRoom, String strType, int intSequenceNo,
			String strEmployeeId) {
		try (Statement ps = conn.createStatement()) {
			ps.execute(
					"INSERT INTO finalsoop.subject_schedule(syear, semester, college_code, block_no, subject_code, day, time, room, type, sequence_no, employee_id) VALUES ('"
							+ strSyear + "', '"
							+ strSemester + "', "
							+ strCollegeCode + ", '"
							+ strBlockNo + "', "
							+ strSubjectCode + ", '"
							+ strDay + "', '"
							+ strTime + "', '"
							+ strRoom + "', '"
							+ strType + "', "
							+ intSequenceNo + ", "
							+ strEmployeeId + ")");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
        
        
        /**
	 * Retrieves all subject schedules from the database.
	 * 
	 * @return ResultSet containing subject schedule records
	 */
	public ResultSet fetchSubjectSchedules() {
		try {
			Statement ps = conn.createStatement();
			return ps.executeQuery("SELECT * FROM finalsoop.subject_schedule_view");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
        
        /**
	 * Deletes a subject schedule record from the database.
	 * 
	 * @param strSubjectCode Subject Code of schedule to delete
         * @param strCollegeCode College Code of schedule to delete
         * @param strSequenceNo  Sequence Number of schedule to delete
         * @param strBlockNo     BlockNo of schedule to delete
         * @param strSemester    Semester of schedule to delete
         * @param strSYear       School year of schedule to delete
	 */
	public void deleteSubjectSchedule(String strSubjectCode, String strCollegeCode, String strSequenceNo, String strBlockNo, String strSemester, String strSYear) {
		try (Statement ps = conn.createStatement()) {
			ps.execute("DELETE FROM finalsoop.subject_schedule WHERE "
                                + "subject_code = '" + strSubjectCode + 
                                "' AND college_code = '" + strCollegeCode + 
                                "' AND syear = '" + strSYear +
                                "' AND semester = '" + strSemester + 
                                "' AND block_no = '" + strBlockNo +
                                "' AND sequence_no = " + strSequenceNo
                        );
		} catch (SQLException e) { 
			System.out.println(e);
		}
	}
        
        
        	/**
	 * Updates a subject schedule record in the database.
	 * 
	 * @param intSequenceNo  Sequence number to update
	 * @param strSYear       New school year
	 * @param strSemester    New semester
	 * @param strCollegeCode New college code
	 * @param strBlockNo     New block number
	 * @param strSubjectCode New subject code
	 * @param strDay         New day
	 * @param strTime        New time
	 * @param strRoom        New room
	 * @param strType        New type
	 * @param strEmployeeId  New employee ID
	 */
	public void updateSubjectSchedule(String strSYear, String strSemester, String strCollegeCode, String strBlockNo,
			String strSubjectCode, String strDay, String strTime, String strRoom, String strType, int intSequenceNo,
			String strEmployeeId) {
		try (Statement ps = conn.createStatement()) {
			ps.execute("UPDATE finalsoop.subject_schedule SET syear = '" + strSYear + "', semester = '" + strSemester
					+ "', college_code = " + strCollegeCode
					+ ", block_no = '" + strBlockNo + "', subject_code = " + strSubjectCode + ", day = '" + strDay
					+ "', time = '" + strTime
					+ "', room = '" + strRoom 
                                        + "', type = '" + strType 
                                        + "', employee_id = " + strEmployeeId
                                        + ", sequence_no = " + intSequenceNo
					+ " WHERE subject_code = " + strSubjectCode + 
                                            " AND college_code = " + strCollegeCode + 
                                            " AND syear = '" + strSYear +
                                            "' AND semester = '" + strSemester + 
                                            "' AND block_no = '" + strBlockNo +
                                            "' AND sequence_no = " + intSequenceNo);
		} catch (SQLException e) {
			System.out.println(e);
                        System.out.println("UPDATE finalsoop.subject_schedule SET syear = '" + strSYear + "', semester = '" + strSemester
					+ "', college_code = '" + strCollegeCode
					+ "', block_no = '" + strBlockNo + "', subject_code = " + strSubjectCode + ", day = '" + strDay
					+ "', time = '" + strTime
					+ "', room = '" + strRoom 
                                        + "', type = '" + strType 
                                        + "', employee_id = " + strEmployeeId
                                        + ", sequence_no = " + intSequenceNo
					+ " WHERE subject_code = " + strSubjectCode + 
                                            " AND college_code = " + strCollegeCode + 
                                            " AND syear = '" + strSYear +
                                            "' AND semester = '" + strSemester + 
                                            "' AND block_no = '" + strBlockNo +
                                            "' AND sequence_no = " + intSequenceNo);
		}
	}
}
