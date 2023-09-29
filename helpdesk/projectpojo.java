package com.amysoftech.helpdesk;

public class projectpojo {
    String id;
    String CustomerName;
    String ProjectID;
    String ProjectName;
    String created_at;

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

    public String getProjectID() {
        return ProjectID;
    }

    public void setProjectID(String projectID) {
        ProjectID = projectID;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public projectpojo(String id, String customerName, String projectID, String projectName, String created_at) {
        this.id = id;
        CustomerName = customerName;
        ProjectID = projectID;
        ProjectName = projectName;
        this.created_at = created_at;
    }
}
