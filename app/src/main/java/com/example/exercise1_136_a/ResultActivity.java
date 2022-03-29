package com.example.exercise1_136_a;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView txtTask, txtKind, txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtTask = findViewById(R.id.textTask);
        txtKind = findViewById(R.id.textKind);
        txtTime = findViewById(R.id.textTime);

        Bundle bundle = getIntent().getExtras();

        String theTask = bundle.getString("b");
        String theKind = bundle.getString("c");
        String theTime = bundle.getString("d");

        txtTask.setText(theTask);
        txtKind.setText(theKind);
        txtTime.setText(theTime);
    }


}