package com.rh.rh.utils;

import jakarta.servlet.http.HttpServletRequest;

public class ApiUrl {
    private String mots = "";
    private static final String URL_EMPLOYEE = "/api/employee";
    private static final String URL_DASHBOARD = "/api/dashboard";
    private static final String URL_DEPARTMENT = "/api/department";
    private static final String URL_RECRUITMENT = "/api/recruitment";
    private static final String URL_RH = "/api/rh";
    private  String list = "";

    public ApiUrl() {}

    public ApiUrl(String mots, String list) {
        this.mots = mots;
        this.list = list;
    }

    public String getMots() {
        return this.mots;
    }

    public String getList() {
        return list;
    }

    public void setMots(String mots) {
        this.mots = mots;
    }

    public void setList(String list) {
        this.list = list;
    }

    public static boolean getEmployee(HttpServletRequest request) {
        return request.getRequestURI().startsWith(ApiUrl.URL_EMPLOYEE);
    }
}
