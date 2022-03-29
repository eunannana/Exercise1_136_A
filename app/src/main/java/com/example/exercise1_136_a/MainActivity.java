package com.example.exercise1_136_a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonSignIn;

    EditText id_name, id_password;

    TextView buttonRegister;

    String name, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSignIn=findViewById(R.id.idSignIn);

        id_name=findViewById(R.id.idName);

        id_password=findViewById(R.id.idPassword);

        buttonRegister = findViewById(R.id.RegisterButton);

        buttonSignIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                validate();
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(), RegisterActivity.class);

                startActivity(intent);
            }
        });
    }
    public void validate() {
        name = id_name.getText().toString();
        password = id_password.getText().toString();

        id_name=findViewById(R.id.idName);

        id_password=findViewById(R.id.idPassword);

        String thename = "Ann";

        String pass = "thisisann";

        if (name.isEmpty() && password.isEmpty()) {
            id_name.setError("name is required!");
            id_password.setError("password is required!");
        } else {
            if (name.equals(thename) && password.equals(pass)) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "Successful Login!", Toast.LENGTH_LONG);
                t.show();

                Bundle b = new Bundle();

                b.putString("a", name.trim());

                Intent i = new Intent(getApplicationContext(), TaskActivity.class);

                i.putExtras(b);

                startActivity(i);

            } else if (!name.equals(name) && password.equals(pass)) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "Input the correct name!", Toast.LENGTH_LONG);
                t.show();
            } else if (name.equals(name) && !password.equals(pass)) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "Input the correct password!", Toast.LENGTH_LONG);
                t.show();

            } else if(!name.equals(name) && !password.equals(pass)){
                Toast t = Toast.makeText(getApplicationContext(),
                        "Input the correct name and password!", Toast.LENGTH_LONG);
                t.show();
            } else if (name.isEmpty()) {
                id_name.setError("Name is required!");
            } else if (password.isEmpty()){
                id_password.setError("Password is required");
            }
        }
    }
}