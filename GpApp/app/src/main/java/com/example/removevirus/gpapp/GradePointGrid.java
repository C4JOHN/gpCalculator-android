package com.example.removevirus.gpapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.content.res.TypedArrayUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GradePointGrid extends Fragment {
    View view;
    static ArrayList<Integer> enteredGrades=new ArrayList<>();
    ArrayList<String> grades=new ArrayList<>();
    public GradePointGrid() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_grade_point_grid, container, false);

        TextView courses;
        TextView credits;
        Spinner spin;

        // initializing the grades
        grades.add("Grades");grades.add("A"); grades.add("B");
        grades.add("C"); grades.add("D"); grades.add("E"); grades.add("F");


        GridLayout layout=(GridLayout)view.findViewById(R.id.gridLayout);

        for(int i=0; i<5;i++) {
            final int x=i;
            courses=new TextView(getActivity());
            courses.setText("hello");

            credits=new TextView(getActivity());
            credits.setText("hi");

            enteredGrades.add(0);

            spin=new Spinner(getActivity());
            ArrayAdapter<String> spinAdap=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,grades);
            spinAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin.setAdapter(spinAdap);

            spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selected = parent.getItemAtPosition(position).toString();
                    if (position > 0) {
                        switch (selected) {
                            case "A":
                                enteredGrades.set(x, 5);
                                break;
                            case "B":
                                enteredGrades.set(x, 4);
                                break;
                            case "C":
                                enteredGrades.set(x, 3);
                                break;
                            case "D":
                                enteredGrades.set(x, 2);
                                break;
                            case "E":
                                enteredGrades.set(x, 1);
                                break;
                            case "F":
                                enteredGrades.set(x, 0);
                                break;
                        }
                        Toast.makeText(getActivity(), enteredGrades.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
           // GridLayout.LayoutParams param = new GridLayout.LayoutParams(GridLayout.spec(1, GridLayout.CENTER), GridLayout.spec(1, GridLayout.CENTER));
            //param.topMargin = 5;

            layout.addView(courses,new GridLayout.LayoutParams(
                    GridLayout.spec(i, GridLayout.CENTER), GridLayout.spec(0, GridLayout.CENTER)));
            layout.addView(credits,new GridLayout.LayoutParams(
                    GridLayout.spec(i, GridLayout.CENTER), GridLayout.spec(1, GridLayout.CENTER)));
            layout.addView(spin,new GridLayout.LayoutParams(
                    GridLayout.spec(i, GridLayout.CENTER), GridLayout.spec(2, GridLayout.CENTER)));

        }

        return view;

    }

}


