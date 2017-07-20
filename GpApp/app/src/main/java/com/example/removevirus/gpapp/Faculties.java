package com.example.removevirus.gpapp;

import java.util.ArrayList;
import java.util.HashMap;

public class Faculties {

    //declaring properties for this class
    public String nameOfFaculty;
    private  Integer numberOfDepartments;
    private ArrayList<Department> departments;
    private HashMap<String,Department> deptMap;

    // setting the number of courses for each level in each deparment
    public Faculties(){
        ///
    }
    public Faculties(String name){
        // initializing properties
        numberOfDepartments=0;
        departments=new ArrayList<>();
        deptMap=new HashMap<>();
        setNameOfFaculty(name);
    }
    public String getNameOfFaculty() {
        return nameOfFaculty;
    }
    public final void setNameOfFaculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }
    public Integer getNumberOfDepartments() {
        return numberOfDepartments;
    }
    public ArrayList<Department> getDepartments() {
        return departments;
    }
    public void setDepartments(Department... departments) {
        for(Department loop: departments){
            this.departments.add(loop);
            this.deptMap.put(loop.getDepartmentName(), loop);
        }
    }
    public HashMap<String, Department> getDeptMap() {
        return deptMap;
    }
}

