package com.example.a25691.classschedule;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class main_class extends AppCompatActivity {

    int classAmt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_class);
        final Context con = this;
        final Button backbttn = findViewById(R.id.ClassesBackButton);
        backbttn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent main_class_page = new Intent(con, MainActivity.class);
                startActivity(main_class_page);
            }
        });

        Button Create = findViewById(R.id.CreateClass);
        Create.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent main_class_page = new Intent(con, ClassCreationActivity.class);
                startActivity(main_class_page);

            }
        });
    }

    /*
    @Override
    protected void onStart(){
        super.onStart();
        LinearLayout mainLL = findViewById(R.id.YourClassesLayout);

        for (int v = 0; v < classAmt; v++) {
            LinearLayout ll = mainLL.findViewWithTag(v);
            mainLL.removeView(ll);
        }

        class_creator[] classes = class_creator.getClasses();
        int var = classAmt + 1;
        if (classAmt == 0) {
            var = 0;
        }
        for (int i = var; i<class_creator.getClassAmount(); i++) {
            dispClass(mainLL, classes[i], this, i);
        }

        classAmt = class_creator.getClassAmount();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        LinearLayout mainLL = findViewById(R.id.YourClassesLayout);

        for (int v = 0; v < classAmt; v++) {
            LinearLayout ll = mainLL.findViewWithTag(v);
            mainLL.removeView(ll);
        }

        class_creator[] classes = class_creator.getClasses();
        int var = classAmt + 1;
        if (classAmt == 0) {
            var = 0;
        }
        for (int i = var; i<class_creator.getClassAmount(); i++) {
            dispClass(mainLL, classes[i], this, i);
        }

        classAmt = class_creator.getClassAmount();
    }*/

    @Override
    protected void onResume(){
        super.onResume();
        if (class_creator.getClassAmount() > 0) {
            LinearLayout mainLL = findViewById(R.id.YourClassesLayout);

            for (int v = 0; v < classAmt; v++) {
                LinearLayout ll = mainLL.findViewWithTag(v);
                mainLL.removeView(ll);
            }

            ArrayList<class_creator> classes = class_creator.getClasses();
            for (int i = 0; i < class_creator.getClassAmount(); i++) {
                dispClass(mainLL, classes.get(i), this, i);
            }

            classAmt = class_creator.getClassAmount();
        }
    }


    public void dispClass(LinearLayout mainLL, class_creator classData, Context con, int num) {
        final Context CONTEXT = con;
        final String className = classData.getClassName();
        final int tNum = num;

        LinearLayout newLayout = new LinearLayout(this);
        newLayout.setTag(tNum);
        newLayout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        newLayout.setOrientation(LinearLayout.HORIZONTAL);
        newLayout.setWeightSum(10);
        newLayout.setPadding(50,10,20,10);
        mainLL.addView(newLayout);

        TextView tv = new TextView(getApplicationContext());
        tv.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                9f));
        tv.setText(className);

        Button b = new Button(getApplicationContext());
        b.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1f));
        b.setText("Details");

        newLayout.addView(tv);
        newLayout.addView(b);

        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent newpage = new Intent(CONTEXT, viewindividualclass.class);
                newpage.putExtra("ClassDataKey", className);
                newpage.putExtra("tagNum", Integer.toString(tNum));
                startActivity(newpage);

            }
        });


    }
}
