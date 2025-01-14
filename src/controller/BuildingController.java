/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.BuildingModel;
import view.DashboardView;

/**
 *
 * @author Mariano
 */
public class BuildingController {
    
    BuildingModel buildingModel = null;
    DashboardView dashboardView = null;
    
    
    public BuildingController( BuildingModel buildingModel, DashboardView dashboardView ) {
        this.buildingModel = buildingModel;
        this.dashboardView = dashboardView;
    }
    
    
}
