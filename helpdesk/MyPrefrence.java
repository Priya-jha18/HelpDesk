package com.amysoftech.helpdesk;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPrefrence {

    private static final String SHARED_PREF_NAME = "com.yoeki.zipnach";
    private static final String MANDATE = "mandate";
    private static MyPrefrence mInstance;
    private static Context mCtx;
    private String USER_ID = "USER_ID";
    private String LOGIN_STATUS = "LOGIN_STATUS";
    private String EMP_ROLE = "EMP_ROLE";
    private String ORGANIZATION = "ORGANIZATION";
    private String ACCESS_TOKEN = "ACCESS_TOKEN";
    private String USER_NAME = "USER_NAME";
    private String EMP_CODE = "EMP_CODE";
    private String EMP_RANK = "EMP_RANK";
    private String EMP_DOB = "EMP_DOB";
    private String EMP_PHOTO = "EMP_PHOTO";
    private String EMP_EMAIL = "EMP_EMAIL";
    private String GetEMP_ROLE = "GetEMP_ROLE";
    private String NOTICE_PERIOD = "NOTICE_PERIOD";
    private String PROBATION_DATE = "PROBATION_DATE";
    private String DATE_OF_JOINING = "DATE_OF_JOINING";

    public MyPrefrence(Context context) {
        mCtx = context;
    }

    public static synchronized MyPrefrence getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MyPrefrence(context);
        }
        return mInstance;
    }


    public boolean SetLoginStatus(String data) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LOGIN_STATUS, data);
        editor.apply();
        return true;
    }

    public String GetLoginStatus() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(LOGIN_STATUS, "");
    }
public boolean SetEMP_ROLE(String data) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(EMP_ROLE, data);
        editor.apply();
        return true;
    }

    public String GETEMPROLE() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(EMP_ROLE, "");
    }
public boolean SetOrganization(String data) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ORGANIZATION, data);
        editor.apply();
        return true;
    }

    public String GETOrganization() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(ORGANIZATION, "");
    }

    public boolean SetAcessToken(String data) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ACCESS_TOKEN, data);
        editor.apply();
        return true;
    }

    public String GetAccessToken() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(ACCESS_TOKEN, "");
    }

    public boolean SetUser_ID(String data) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_ID, data);
        editor.apply();
        return true;
    }

    public String GetUser_ID() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(USER_ID, "");
    }

    public boolean SetUser_Name(String data) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_NAME, data);
        editor.apply();
        return true;
    }


    public String GetUser_Name() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(USER_NAME, "");
    }

    public boolean SetEMP_CODE(String data) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(EMP_CODE, data);
        editor.apply();
        return true;
    }

    public String GetEMP_CODE() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(EMP_CODE, "");
    }

    public boolean SetEMP_RANK(String data) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(EMP_RANK, data);
        editor.apply();
        return true;
    }

    public String GetEMP_RANK() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(EMP_RANK, "");
    }

    public boolean SetEMP_DOB(String data) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(EMP_DOB, data);
        editor.apply();
        return true;
    }

    public String GetEMP_DOB() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(EMP_DOB, "");
    }

    public boolean SetEMP_PHOTO(String data) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(EMP_PHOTO, data);
        editor.apply();
        return true;
    }

    public String GetEMP_PHOTO() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(EMP_PHOTO, "");
    }

    public boolean SetEMP_EMAIL(String data) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(EMP_EMAIL, data);
        editor.apply();
        return true;
    }

    public String GetEMP_EMAIL() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(EMP_EMAIL, "");
    }

    public boolean SetNOTICE_PERIOD(String data) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NOTICE_PERIOD, data);
        editor.apply();
        return true;
    }

    public String GetNOTICE_PERIOD() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(NOTICE_PERIOD, "");
    }

    public boolean SetPROBATION_DATE(String data) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PROBATION_DATE, data);
        editor.apply();
        return true;
    }

    public String GetPROBATION_DATE() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(PROBATION_DATE, "");
    }

    public boolean SetDATE_OF_JOINING(String data) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(DATE_OF_JOINING, data);
        editor.apply();
        return true;
    }

    public String GetDATE_OF_JOINING() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(DATE_OF_JOINING, "");
    }
}
