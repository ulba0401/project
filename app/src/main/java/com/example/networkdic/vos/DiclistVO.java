package com.example.networkdic.vos;

import java.io.Serializable;

public class DiclistVO implements Serializable {
    private String abbword;
    private String fullname;
    private String explanation;
    private String korword;

    public DiclistVO(String abbword, String fullname, String explanation, String korword) {
        this.abbword = abbword;
        this.fullname = fullname;
        this.explanation = explanation;
        this.korword = korword;
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
}
