package com.example.exercise1_136_a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {

    EditText edtName, edtEmail, edtPassword, edtRepass;

    Button buttonRegist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        buttonRegist = findViewById(R.id.buttonRegister);

        edtName = findViewById(R.id.edName);
        edtEmail = findViewById(R.id.edEmail);
        edtPassword = findViewById(R.id.edPassword);
        edtRepass = findViewById(R.id.edRepass);

        buttonRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if(edtName.getText().toString().isEmpty() && edtEmail.getText().toString().isEmpty()){
                    edtName.setError("Name is required!");
                    edtEmail.setError("E-mail is required!");
                } else if(edtName.getText().toString().isEmpty()){
                    edtName.setError("Name is required!");
                } else if(edtEmail.getText().toString().isEmpty()){
                    edtEmail.setError("E-mail is required!");
                } else if (edtName.getText().toString().equals(edtName.getText().toString()) && edtEmail.getText().toString().equals(edtEmail.getText().toString()) && !edtPassword.getText().toString().equals(edtRepass.getText().toString())){
                    Snackbar.make(view, "Password and Repassword must be same!", Snackbar.LENGTH_LONG).show();
                } else if(edtName.getText().toString().equals(edtName.getText().toString()) && edtEmail.getText().toString().equals(edtEmail.getText().toString()) && edtPassword.getText().toString().equals(edtRepass.getText().toString())){

                        Toast.makeText(getApplicationContext(), "Successfully Register!", Toast.LENGTH_LONG).show();

                        Bundle b = new Bundle();

                        b.putString("a", edtName.getText().toString().trim());

                        Intent in = new Intent(getApplicationContext(), TaskActivity.class);

                        in.putExtras(b);

                        startActivity(in);
                }
            }
        });
    }
}


