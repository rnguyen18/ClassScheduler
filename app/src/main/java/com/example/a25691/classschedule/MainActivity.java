package com.example.a25691.classschedule;

import android.content.Intent;
import android.view.View;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Resources res = getResources();



    }

    public void openMainClassPage(View view) {
        Intent main_class_page = new Intent(this, main_class.class);
        startActivity(main_class_page);
    }
}
