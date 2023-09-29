package com.amysoftech.helpdesk;

public class CreateTicketModel {
    String Status;
    String Message;

    public CreateTicketModel(String status, String message) {
        Status = status;
        Message = message;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
