package com.amysoftech.helpdesk;

import java.util.ArrayList;

public class processmodel {
    String Status;
    ArrayList<processPojo>AssignDataList;

    public processmodel(String status, ArrayList<processPojo> assignDataList) {

        Status = status;
        AssignDataList = assignDataList;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public ArrayList<processPojo> getAssignDataList() {
        return AssignDataList;
    }

    public void setAssignDataList(ArrayList<processPojo> assignDataList) {
        AssignDataList = assignDataList;
    }
}
