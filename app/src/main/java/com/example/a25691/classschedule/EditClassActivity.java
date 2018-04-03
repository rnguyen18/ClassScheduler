package com.example.a25691.classschedule;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class EditClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_class);


        Bundle extras =  getIntent().getExtras();
        final String data = extras.getString("ClassDataKey");
        final class_creator viewingClass = class_creator.getClassFromName(data);

        final Context con = this;
        final TextView className = findViewById(R.id.ENameInput);
        final EditText professor = findViewById(R.id.EProfessorInput);
        final EditText location = findViewById(R.id.ELocationInput);
        final TextView error = findViewById(R.id.ErrorMessage1);
        final TimePicker start = findViewById(R.id.timepicker3);
        final TimePicker end = findViewById(R.id.timepicker4);



        final CheckBox[] boxes = new CheckBox[7];
        boxes[0] = findViewById(R.id.EInputweekday1);
        boxes[1] = findViewById(R.id.EInputweekday2);
        boxes[2] = findViewById(R.id.EInputweekday3);
        boxes[3] = findViewById(R.id.EInputweekday4);
        boxes[4] = findViewById(R.id.EInputweekday5);
        boxes[5] = findViewById(R.id.EInputweekday6);
        boxes[6] = findViewById(R.id.EInputweekday7);


        className.setText(data);
        professor.setText(viewingClass.getProfessor());
        location.setText(viewingClass.getLocation());

        final boolean[] dayBools = viewingClass.getDays();

        for (int i = 0; i < dayBools.length; i++) {
            boxes[i].setChecked(dayBools[i]);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            start.setHour(viewingClass.getSHour());
            start.setMinute(viewingClass.getSMinute());
        } else {
            start.setCurrentHour(viewingClass.getSHour());
            start.setCurrentMinute(viewingClass.getSMinute());
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            end.setHour(viewingClass.getEHour());
            end.setMinute(viewingClass.getEMinute());
        } else {
            end.setCurrentHour(viewingClass.getEHour());
            end.setCurrentMinute(viewingClass.getEMinute());
        }

        Button SaveButton = findViewById(R.id.SaveButton);
        SaveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                boolean[] boxCheck = new boolean[7];
                boolean boxChecked = false;

                for (int box = 0; box < boxes.length; box++) {

                    boxCheck[box] = boxes[box].isChecked();
                    if (boxes[box].isChecked()) {
                        boxChecked = true;
                    }
                }

                if (!professor.getText().toString().trim().equals("")) {
                    if (!location.getText().toString().trim().equals("")) {
                        if (boxChecked) {
                            viewingClass.setProfessor(professor.getText().toString());
                            viewingClass.setLocation(location.getText().toString());
                            viewingClass.setDays(boxCheck);
                            viewingClass.setSHour(start.getCurrentHour());
                            viewingClass.setSMinute(start.getCurrentMinute());
                            viewingClass.setEHour(end.getCurrentHour());
                            viewingClass.setEMinutes(end.getCurrentMinute());

                            Intent newpage = new Intent(con, main_class.class);
                            startActivity(newpage);

                        } else {
                            error.setText("Weekday Needed");
                        }
                    } else {
                        error.setText("Location Needed");
                    }
                } else {
                    error.setText("Professor Needed");
                }
            }
        });
    }
}
