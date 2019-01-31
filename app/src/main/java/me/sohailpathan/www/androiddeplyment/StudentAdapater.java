package me.sohailpathan.www.androiddeplyment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapater extends RecyclerView.Adapter<StudentAdapater.StudentViewHolder>
{
private ArrayList<StudentClass> studentlist= new ArrayList<StudentClass>();

public StudentAdapater
        (ArrayList<StudentClass> al){
    studentlist=al;
}

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        StudentClass student;
        ImageView img;
        TextView txt_name, txt_regno;

        public StudentViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.student_image);
            txt_name = itemView.findViewById(R.id.student_name);
            txt_regno = itemView.findViewById(R.id.student_regno);
        }

        public void bindData(StudentClass s) {
            student = s;
            img.setImageResource(student.getImage());
            txt_name.setText(student.getName());
            txt_regno.setText(String.valueOf(student.getRegno()));
        }
    }


    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder
            (@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.row, viewGroup, false);
        return new StudentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int i) {
       studentViewHolder.bindData(studentlist.get(i));
    }

    @Override
    public int getItemCount() {
        return studentlist.size();
    }
}

