package com.example.shortassignment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailPageActivity extends AppCompatActivity {
    TextView tv_name,tv_body;
    String body,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
             body = bundle.getString("body");
             name = bundle.getString("name");
        }

        tv_body = findViewById(R.id.tv_body);
        tv_name = findViewById(R.id.tv_name);

        tv_body.setText(body);
        tv_name.setText(name);
    }

}