package com.learning.annotation.documents;


import com.learning.annotation.implementation.ValidDate;
import com.learning.annotation.implementation.ValidName;
import com.learning.annotation.implementation.ValidPanNumber;

import java.util.Date;

/**
 * Created by santoshk on 2/15/18.
 */
public class PanCard  implements com.learning.annotation.documents.BaseDocument {


    @ValidName(type = "String")
    private String fullname;

    @ValidName(type="String")
    private String fatherName;

    public PanCard(String fullname, String panNumber, String fatherName, String issuedBy, Date dob) {
        this.fullname = fullname;
        this.panNumber = panNumber;
        this.fatherName = fatherName;
        this.issuedBy = issuedBy;
        this.dob = dob;
    }

    @ValidPanNumber(type="String")
    private String panNumber;


    private String issuedBy;

    @ValidDate(type=Date.class)
    private Date dob;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }




}