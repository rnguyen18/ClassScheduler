package com.example.a25691.classschedule;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class viewindividualclass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewindividualclass);
        Bundle extras =  getIntent().getExtras();
        final String data = extras.getString("ClassDataKey");
        // final int tagData = Integer.parseInt(extras.getString("tagNum"));
        final Context con = this;

        final class_creator viewingClass = class_creator.getClassFromName(data);
        boolean[] boolData = viewingClass.getDays();
        String daytxt = "";
        for (int d = 0; d < 7; d++) {
            if (boolData[d]) {
                daytxt += class_creator.days[d] + " ";
            }
        }
        String timetxt = viewingClass.getTimePeriod();

        TextView title = findViewById(R.id.individualtitle);
        title.setText(data);
        TextView professor = findViewById(R.id.individualprofessor);
        professor.setText(viewingClass.getProfessor());
        TextView location = findViewById(R.id.locationData);
        location.setText(viewingClass.getLocation());
        TextView day = findViewById(R.id.dateNtimeData1);
        day.setText(daytxt);
        TextView time = findViewById(R.id.dateNtimeData2);
        time.setText(timetxt);
        Button delBttn = findViewById(R.id.deleteClass);
        delBttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                class_creator.deleteClass(viewingClass);
                Intent main_class_page = new Intent(con, main_class.class);
                startActivity(main_class_page);

            }
        });

        Button editBttn = findViewById(R.id.EditClassButton);
        editBttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent main_class_page = new Intent(con, EditClassActivity.class);
                main_class_page.putExtra("ClassDataKey", data);
                startActivity(main_class_page);

            }
        });

    }
}
