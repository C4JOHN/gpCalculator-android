package com.example.removevirus.gpapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Faculties> faculties;

    static ArrayList<String> facList;
    static ArrayList<String> deptList;
    static ArrayList<String> levelList;

    static Faculties selectFac;
    static Department selectDept;
    static Levels selectLevel;

    static ArrayList<Courses> selectedCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        faculties=new ArrayList<>();
        facList=new ArrayList<>();
        deptList=new ArrayList<>();
        levelList=new ArrayList<>();

        selectFac=new Faculties();
        selectDept=new Department();
        selectLevel=new Levels();

        selectedCourse=new ArrayList<>();

        final School school=new School("University Of Benin");
        faculties=school.getFaculties();
        Iterator<Faculties> facIterator=school.getFaculties().iterator();
        while(facIterator.hasNext()){
            facList.add(facIterator.next().getNameOfFaculty());
        }


        final Spinner facSpin=(Spinner)findViewById(R.id.facSpinner);
        Spinner deptSpin=(Spinner)findViewById(R.id.deptSpinner);
        Spinner levSpin=(Spinner)findViewById(R.id.levelSpinner);


        ArrayAdapter<String> facAdapt=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,facList);
        facAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        facSpin.setAdapter(facAdapt);

        facSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectFac=school.getFacultyMap().get(parent.getItemAtPosition(position));
                Toast.makeText(getApplicationContext(),selectFac.getNameOfFaculty(),
                        Toast.LENGTH_LONG).show();

                Iterator<Department> deptIterator=selectFac.getDepartments().iterator();
                deptList.clear();
                while(deptIterator.hasNext()){
                    deptList.add(deptIterator.next().getDepartmentName());
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> deptAdapt=new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,deptList);
        deptAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        deptSpin.setAdapter(deptAdapt);

        deptSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //selectDept=selectFac.getDeptMap().get(parent.getItemAtPosition(position).toString());
                Toast.makeText(getApplicationContext(),selectFac.getNameOfFaculty().toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

 }
         public void calcActivity(View view){
             Intent intent=new Intent(getApplicationContext(),calculateGradePoint.class);
             startActivity(intent);
         }

}
