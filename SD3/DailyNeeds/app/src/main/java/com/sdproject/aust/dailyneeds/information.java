package com.sdproject.aust.dailyneeds;

/**
 * Created by Sakib on 11-Feb-18.
 */

public class information {
    public String email;
    public String password;
    public String id;
    public String section;
    public String semester;
    public String department;
    public String contactNumber;

    public information(String email, String password, String id, String section, String semester, String department, String contactNumber) {
        this.email = email;
        this.password = password;
        this.id = id;
        this.section = section;
        this.semester = semester;
        this.department = department;
        this.contactNumber = contactNumber;
    }
}
