package com.example.removevirus.gpapp;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Department  {

    // declaring local properties for this class

    private Integer numberOfLevels;
    private ArrayList<Levels> levels;
    private String departmentName;
    private Map<String,Levels> levelMaps;

    public Department(){
        this.levels=new ArrayList<>();
        this.departmentName=null;
    }
    public Department(Integer numberOfLevels,String name){
        setDepartmentName(name);
        setNumberOfLevels(numberOfLevels);
        this.levelMaps=new HashMap();
        this.levels=new ArrayList<>();
//        for(int i=1; i<=numberOfLevels;i++){
//            Integer inte=i*100;
//            levels.add(new Levels(inte.toString()));
//        }

    }

    // declaring setters and getters
    public Integer getNumberOfLevels() {
        return numberOfLevels;
    }

    public final void setNumberOfLevels(Integer numberOfLevels) {
        this.numberOfLevels = numberOfLevels;
    }

    public ArrayList<Levels> getLevels() {
        return levels;
    }

    public void setLevels(Levels...levels) {
        for(Levels loop:levels)
            this.levels.add(loop);

        for(Levels loop:levels)
            this.levelMaps.put(loop.getLevelName(),loop);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public final void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Map<String, Levels> getLevelMaps() {
        return levelMaps;
    }
    @Override
    public String toString() {
        return "Department{" + "numberOfLevels=" + this.numberOfLevels + ", levels=" + this.levels + ", departmentName=" + this.departmentName + '}';
    }

}

