package com.amysoftech.helpdesk;

public class processPojo {
    String id;
    String CustomerName;
    String ProcessID;
    String ProcessName;
    String created_at;

    public processPojo(String id, String customerName, String processID, String processName, String created_at) {

        this.id = id;
        CustomerName = customerName;
        ProcessID = processID;
        ProcessName = processName;
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getProcessID() {
        return ProcessID;
    }

    public void setProcessID(String processID) {
        ProcessID = processID;
    }

    public String getProcessName() {
        return ProcessName;
    }

    public void setProcessName(String processName) {
        ProcessName = processName;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
