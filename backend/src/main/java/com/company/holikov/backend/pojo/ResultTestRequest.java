package com.company.holikov.backend.pojo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ResultTestRequest {

    private String studentLogin;

    private String tense;

    private LinkedHashMap<Long,String> map;

    public LinkedHashMap<Long, String> getMap() {
        return map;
    }

    public String getTense() {
        return tense;
    }

    public String getStudentLogin() {
        return studentLogin;
    }
}
