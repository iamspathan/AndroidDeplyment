package me.sohailpathan.www.androiddeplyment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int[] images = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
    String[] names = {"Harjit Singh" , "Satish Kathaute" , "Daud Ibrahim"};
    long[] regno = {11709117,11709118, 11709117};

    private ArrayList<StudentClass> studentList = new ArrayList<StudentClass>();

    RecyclerView students;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//       MyView myView;
        super.onCreate(savedInstanceState);
//        myView = new MyView(this);
        setContentView(R.layout.activity_main);
//        students = findViewById(R.id.student_list);
//        students.setLayoutManager(new GridLayoutManager(this,2));
//        for(int i = 0 ; i < names.length ; i++)
//        {
//            StudentClass obj = new StudentClass(images[i] , names[i], regno[i]);
//            studentList.add(obj);
//        }
//
//        StudentAdapater adapater = new StudentAdapater(studentList);
//        students.setAdapter(adapater);
    }
}
