package com.amysoftech.helpdesk;

import java.util.ArrayList;

public class projectmodel {
    String Status;
    ArrayList<projectpojo> AssignDataList;

    public projectmodel(String status, ArrayList<projectpojo> assignDataList) {

        Status = status;
        AssignDataList = assignDataList;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public ArrayList<projectpojo> getAssignDataList() {
        return AssignDataList;
    }

    public void setAssignDataList(ArrayList<projectpojo> assignDataList) {
        AssignDataList = assignDataList;
    }
}
