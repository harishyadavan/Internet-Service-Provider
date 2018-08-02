package com.example.varundavidpulla.internet;

import android.widget.EditText;


public class Artist {
    private String parentId;
    private String parentName;
    private String parentAddress;
    private String parentOccupation;
    private String parentContact;
    private String parentDob;

    public Artist(EditText name, EditText mb, EditText msg){
        //this constructor is required
    }

    public Artist(String parentId, String parentName, String parentOccupation,String parentContact,String parentDob,String parentAddress) {
        this.parentId = parentId;
        this.parentName = parentName;
        this.parentContact = parentContact;
        this.parentDob = parentDob;
        this.parentAddress = parentAddress;
        this.parentOccupation = parentOccupation;
    }

    public String getparentId() {

        return parentId;
    }

    public String getparentName() {
        return parentName;
    }

    public String getparentContact() {

        return parentContact;
    }
    public String getparentDob() {

        return parentDob;
    }
    public String getparentAddress() {

        return parentAddress;
    }
    public String getparentOccupation() {

        return parentOccupation;
    }
}
