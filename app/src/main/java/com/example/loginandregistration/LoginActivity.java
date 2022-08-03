package com.example.loginandregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView btn;
    EditText inputEmail1,inputPasswordLogin;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn = findViewById(R.id.textViewSignUp);
        inputEmail1 = findViewById(R.id.inputEmail1);
        inputPasswordLogin = findViewById(R.id.inputUsername);
        btnLogin = findViewById(R.id.btnlogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCrededentials();
            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));

            }
        });
    }


    private void checkCrededentials() {
        String email = inputEmail1.getText().toString();
        String password = inputPasswordLogin.getText().toString();


        if (email.isEmpty() || !email.contains("@")){
            showError(inputEmail1,"Email is not valid");
        }
        else if (password.isEmpty() || password.length()<8){
            showError(inputPasswordLogin,"Password must be 8 character");
        }
        else{
            Toast.makeText(this, "call Login Method", Toast.LENGTH_SHORT).show();
        }
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }

}