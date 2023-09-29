package com.amysoftech.helpdesk.pojo;

public class AllTicketPojo {

    String id;
    String IncidentID;
    String OrganizationName;
    String CreatedBy;
    String Title;
    String Description;
    String Priority;
    String created_at;
    String Status;
    String TicketType;
    String AssignedName;
    String DepartmentName;
    String ProjectName;
    String ProcessName;
    String Image;
    String url;

    public AllTicketPojo(String id, String incidentID, String organizationName, String createdBy, String title, String description, String priority, String created_at, String status, String ticketType, String assignedName, String departmentName, String projectName, String processName, String image, String url) {
        this.id = id;
        IncidentID = incidentID;
        OrganizationName = organizationName;
        CreatedBy = createdBy;
        Title = title;
        Description = description;
        Priority = priority;
        this.created_at = created_at;
        Status = status;
        TicketType = ticketType;
        AssignedName = assignedName;
        DepartmentName = departmentName;
        ProjectName = projectName;
        ProcessName = processName;
        Image = image;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIncidentID() {
        return IncidentID;
    }

    public void setIncidentID(String incidentID) {
        IncidentID = incidentID;
    }

    public String getOrganizationName() {
        return OrganizationName;
    }

    public void setOrganizationName(String organizationName) {
        OrganizationName = organizationName;
    }

    public String getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(String createdBy) {
        CreatedBy = createdBy;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getTicketType() {
        return TicketType;
    }

    public void setTicketType(String ticketType) {
        TicketType = ticketType;
    }

    public String getAssignedName() {
        return AssignedName;
    }

    public void setAssignedName(String assignedName) {
        AssignedName = assignedName;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getProcessName() {
        return ProcessName;
    }

    public void setProcessName(String processName) {
        ProcessName = processName;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
