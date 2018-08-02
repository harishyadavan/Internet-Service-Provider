package com.example.varundavidpulla.internet;

/**
 * Created by Varun David Pulla on 17-Dec-17.
 */

public class Track {

    private String classId;
    private String className;
  //  private String courseType;
    private int courseCost;

    public Track() {

    }

    public Track(String id, String courseName, int courseCost) {
        this.className = courseName;
        this.courseCost = courseCost;
       // this.courseType=courseType;
        this.classId = id;
    }

    public String getClassId() {
        return classId;
    }
    public String getClassName() {
        return className;
    }
    public int getCourseCost() {
        return courseCost;
    }
}