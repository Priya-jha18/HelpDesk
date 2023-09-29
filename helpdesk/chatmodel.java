package com.amysoftech.helpdesk;

import java.util.ArrayList;

public class chatmodel {
    String Status;
    ArrayList<chatpojo>TicketLogHistory;

    public chatmodel(String status, ArrayList<chatpojo> ticketLogHistory) {

        Status = status;
        TicketLogHistory = ticketLogHistory;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public ArrayList<chatpojo> getTicketLogHistory() {
        return TicketLogHistory;
    }

    public void setTicketLogHistory(ArrayList<chatpojo> ticketLogHistory) {
        TicketLogHistory = ticketLogHistory;
    }
}
