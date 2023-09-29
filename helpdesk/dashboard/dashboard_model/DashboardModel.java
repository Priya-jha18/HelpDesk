package com.amysoftech.helpdesk.dashboard.dashboard_model;

import com.amysoftech.helpdesk.dashboard.pojo.DashboardPojo;

import java.util.ArrayList;

public class DashboardModel {

    String Status;
    ArrayList<DashboardPojo> DashboardStatusList;

    public DashboardModel(String status, ArrayList<DashboardPojo> dashboardStatusList) {
        Status = status;
        DashboardStatusList = dashboardStatusList;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public ArrayList<DashboardPojo> getDashboardStatusList() {
        return DashboardStatusList;
    }

    public void setDashboardStatusList(ArrayList<DashboardPojo> dashboardStatusList) {
        DashboardStatusList = dashboardStatusList;
    }
}
