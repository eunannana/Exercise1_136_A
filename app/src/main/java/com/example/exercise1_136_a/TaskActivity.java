package com.example.exercise1_136_a;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class TaskActivity extends AppCompatActivity {

    TextView txtName;
    EditText edtTask, edtKind, edtTime;

    String theTask, theKind, theTime;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        txtName = findViewById(R.id.tvName);

        Bundle bundle = getIntent().getExtras();

        String thename = bundle.getString("a");

        txtName.setText(thename);

        edtTask = findViewById(R.id.edTask);
        edtKind = findViewById(R.id.edKind);
        edtTime = findViewById(R.id.edTime);
        fab = findViewById(R.id.fabSave);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                theTask = edtTask.getText().toString();
                theKind = edtKind.getText().toString();
                theTime = edtTime.getText().toString();

                if (theTask.isEmpty() && theTime.isEmpty() && theKind.isEmpty()){
                    Toast.makeText(getApplicationContext(), "All data is required!", Toast.LENGTH_LONG).show();
                }else if(theKind.isEmpty() && theTime.isEmpty()){
                    edtKind.setError("Kind of Task!");
                    edtTime.setError("Time of Task!");
                }else if (theKind.isEmpty()) {
                    edtKind.setError("Kind of Task!");
                } else if (theTime.isEmpty()) {
                    edtTime.setError("Time of Task!");
                }else if(theTask.equals(theTask) && theKind.equals(theKind) && theTime.equals(theTime)) {
                    Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();

                    Bundle b = new Bundle();

                    b.putString("b", theTask.trim());
                    b.putString("c", theKind.trim());
                    b.putString("d", theTime.trim());

                    Intent ii = new Intent(getApplicationContext(), ResultActivity.class);

                    ii.putExtras(b);

                    startActivity(ii);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        theTask = edtTask.getText().toString();
        theKind = edtKind.getText().toString();
        theTime = edtTime.getText().toString();

        if (item.getItemId() == R.id.logout) {
            Intent iii = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(iii);
        }else if (theTask.isEmpty() && theTime.isEmpty() && theKind.isEmpty()){
            Toast.makeText(getApplicationContext(), "All data is required!", Toast.LENGTH_LONG).show();
        }else if(theKind.isEmpty() && theTime.isEmpty()){
            edtKind.setError("Kind of Task!");
            edtTime.setError("Time of Task!");
        }else if (theKind.isEmpty()) {
                edtKind.setError("Kind of Task!");
        } else if (theTime.isEmpty()) {
                edtTime.setError("Time of Task!");
        }else if(item.getItemId() == R.id.submit && theTask.equals(theTask) && theKind.equals(theKind) && theTime.equals(theTime)) {
            Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_LONG).show();

            Bundle b = new Bundle();

            b.putString("b", theTask.trim());
            b.putString("c", theKind.trim());
            b.putString("d", theTime.trim());

            Intent ii = new Intent(getApplicationContext(), ResultActivity.class);

            ii.putExtras(b);

            startActivity(ii);
        }
        return super.onOptionsItemSelected(item);
    }
}