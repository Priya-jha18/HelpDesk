package com.amysoftech.helpdesk;

public class LoginModule {
    String Status;
    String Message;
    String OrganizationID;
    String OrganizationName;
    String id;
    String type;
    String firstname;
    String middlename;
    String lastname;
    String role;
    String username;
    String date_created;
    String email;
    String created_by;
    String accesstoken;
    String u_photo;
    String device_token;

    public LoginModule(String status, String message, String organizationID, String organizationName, String id, String type, String firstname, String middlename, String lastname, String role, String username, String date_created, String email, String created_by, String accesstoken, String u_photo, String device_token) {

        Status = status;
        Message = message;
        OrganizationID = organizationID;
        OrganizationName = organizationName;
        this.id = id;
        this.type = type;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.role = role;
        this.username = username;
        this.date_created = date_created;
        this.email = email;
        this.created_by = created_by;
        this.accesstoken = accesstoken;
        this.u_photo = u_photo;
        this.device_token = device_token;
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

    public String getOrganizationID() {
        return OrganizationID;
    }

    public void setOrganizationID(String organizationID) {
        OrganizationID = organizationID;
    }

    public String getOrganizationName() {
        return OrganizationName;
    }

    public void setOrganizationName(String organizationName) {
        OrganizationName = organizationName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public String getU_photo() {
        return u_photo;
    }

    public void setU_photo(String u_photo) {
        this.u_photo = u_photo;
    }

    public String getDevice_token() {
        return device_token;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }
}
