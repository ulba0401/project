package com.example.networkdic.vos;

import java.io.Serializable;

public class DiclistVO implements Serializable {
    private String abbword;
    private String fullname;
    private String explanation;
    private String korword;
    private String unit;
    private String bookmark;

    //로그인 후 받을 내용
    public DiclistVO(String abbword, String fullname, String explanation, String korword, String unit, String bookmark) {
        this.abbword = abbword;
        this.fullname = fullname;
        this.explanation = explanation;
        this.korword = korword;
        this.unit = unit;
        this.bookmark = bookmark;
    }

    //로그인 안했을시 받을 내용
    public DiclistVO(String abbword, String fullname, String explanation, String korword, String unit) {
        this.abbword = abbword;
        this.fullname = fullname;
        this.explanation = explanation;
        this.korword = korword;
        this.unit = unit;
    }

    public String getAbbword() {
        return abbword;
    }

    public void setAbbword(String abbword) {
        this.abbword = abbword;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getKorword() {
        return korword;
    }

    public void setKorword(String korword) {
        this.korword = korword;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
