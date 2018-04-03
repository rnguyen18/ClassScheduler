package com.example.a25691.classschedule;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class ClassCreationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_creation);
        final Context con = this;
        final EditText className = findViewById(R.id.NameInput);
        final EditText professor = findViewById(R.id.ProfessorInput);
        final EditText location = findViewById(R.id.LocationInput);
        final TextView error = findViewById(R.id.ErrorMessage);
        final TimePicker start = findViewById(R.id.timepicker1);
        final TimePicker end = findViewById(R.id.timepicker2);

        final CheckBox[] boxes = new CheckBox[7];
        boxes[0] = findViewById(R.id.Inputweekday1);
        boxes[1] = findViewById(R.id.Inputweekday2);
        boxes[2] = findViewById(R.id.Inputweekday3);
        boxes[3] = findViewById(R.id.Inputweekday4);
        boxes[4] = findViewById(R.id.Inputweekday5);
        boxes[5] = findViewById(R.id.Inputweekday6);
        boxes[6] = findViewById(R.id.Inputweekday7);


        Button CreateButton = findViewById(R.id.CreateButton);
        CreateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                boolean[] boxCheck = new boolean[7];
                boolean boxChecked = false;

                for (int box = 0; box < boxes.length; box++) {

                        boxCheck[box] = boxes[box].isChecked();
                        if (boxes[box].isChecked()) {
                            boxChecked = true;
                        }
                }

                if (!className.getText().toString().trim().equals("")) {
                    if (!professor.getText().toString().trim().equals("")) {
                        if (!location.getText().toString().trim().equals("")) {
                            if (boxChecked) {
                                new class_creator(className.getText().toString(),
                                        professor.getText().toString(),
                                        location.getText().toString(),
                                        boxCheck,
                                        start.getCurrentHour(), start.getCurrentMinute(), end.getCurrentHour(), end.getCurrentMinute());

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
                } else {
                    error.setText("Course Name Needed");
                }
            }
        });



    }
}
