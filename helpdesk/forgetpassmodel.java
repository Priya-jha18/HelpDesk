package com.amysoftech.helpdesk;

public class forgetpassmodel {
    String Status;
    String Message;
    String OTP;

    public forgetpassmodel(String status, String message, String OTP) {

        Status = status;
        Message = message;
        this.OTP = OTP;
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

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }
}
