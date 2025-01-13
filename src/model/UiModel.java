/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mariano
 */
public class UiModel {
    
    // populateTable based on fetch
    public void populateTable(ResultSet rs, javax.swing.JTable table) {
		try {
			DefaultTableModel model = new DefaultTableModel();
			int columnCount = rs.getMetaData().getColumnCount();

			for (int i = 1; i <= columnCount; i++) {
				model.addColumn(rs.getMetaData().getColumnLabel(i));
			}
                        
			while (rs.next()) {
				Object[] row = new Object[columnCount];
				for (int i = 1; i <= columnCount; i++) {
					row[i - 1] = rs.getObject(i);
				}
				model.addRow(row);
			}
			table.setModel(model);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
    
}
