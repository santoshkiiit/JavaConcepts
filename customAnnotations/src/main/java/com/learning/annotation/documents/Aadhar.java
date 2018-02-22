/**
 *
 */
package com.learning.annotation.documents;

import com.learning.annotation.implementation.ValidDate;
import com.learning.annotation.implementation.ValidName;

import java.util.Date;

/**
 * Created by santoshk on 2/15/18.
 */


public class Aadhar implements BaseDocument {

    // assumption: aadhar is the master document which has pan , bank statement as its child documents.


    public Aadhar(String fullname, String gender, String address, Date dob, PanCard panCard, BankStatement bankStatement) {
        this.fullname = fullname;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
        this.panCard = panCard;
        this.bankStatement = bankStatement;
    }

    @ValidName(type="String")
    private String fullname;

    private String gender;

    private String address;

    @ValidDate(type=Date.class)
    private Date dob;

   PanCard panCard ;

    BankStatement bankStatement;



    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public PanCard getPanCard() {
        return panCard;
    }

    public void setPanCard(PanCard panCard) {
        this.panCard = panCard;
    }

    public BankStatement getBankStatement() {
        return bankStatement;
    }

    public void setBankStatement(BankStatement bankStatement) {
        this.bankStatement = bankStatement;
    }



}