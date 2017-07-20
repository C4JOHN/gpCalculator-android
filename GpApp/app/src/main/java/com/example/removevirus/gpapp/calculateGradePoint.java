package com.example.removevirus.gpapp;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

public class calculateGradePoint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_grade_point);

        Fragment btnFrag=new SemesterButtons();
        android.app.FragmentTransaction trans= getFragmentManager().beginTransaction();
        trans.add(R.id.semesterbtns,btnFrag);


        Fragment gridFrag=new GradePointGrid();
        trans.add(R.id.gridLayout, gridFrag);
        trans.commit();

    }
}
