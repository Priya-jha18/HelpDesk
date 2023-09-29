package com.amysoftech.helpdesk.model;



import com.amysoftech.helpdesk.AllTicketPojo;

import java.util.ArrayList;

public class AllTicketModel {

    String Status;
    ArrayList<AllTicketPojo> AllTicketList;


    public AllTicketModel(String status, ArrayList<AllTicketPojo> allTicketList) {
        Status = status;
        AllTicketList = allTicketList;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public ArrayList<AllTicketPojo> getAllTicketList() {
        return AllTicketList;
    }

    public void setAllTicketList(ArrayList<AllTicketPojo> allTicketList) {
        AllTicketList = allTicketList;
    }
}
