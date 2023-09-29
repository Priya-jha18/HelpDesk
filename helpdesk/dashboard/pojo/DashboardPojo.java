package com.amysoftech.helpdesk.dashboard.pojo;

public class DashboardPojo {

    String KeyName;
    String KeyCount;

    public DashboardPojo(String keyName, String keyCount) {
        KeyName = keyName;
        KeyCount = keyCount;
    }

    public String getKeyName() {
        return KeyName;
    }

    public void setKeyName(String keyName) {
        KeyName = keyName;
    }

    public String getKeyCount() {
        return KeyCount;
    }

    public void setKeyCount(String keyCount) {
        KeyCount = keyCount;
    }
}
