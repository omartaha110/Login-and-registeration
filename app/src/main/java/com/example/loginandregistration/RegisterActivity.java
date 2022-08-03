package com.example.loginandregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    TextView btn;
    private EditText inputUsername,inputPassword,inputEmail,inputConfirmPassword;
    Button btnRegister;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn = findViewById(R.id.alreadyHaveAccount);
        inputUsername = findViewById(R.id.inputUsername);
        inputEmail = findViewById(R.id.inputEmail1);
        inputPassword = findViewById(R.id.inputPassword);
        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCrededentials();
            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }

    private void checkCrededentials() {
        String username = inputUsername.getText().toString();
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        String confirmPassword = inputConfirmPassword.getText().toString();

        if (username.isEmpty() || username.length()<8){
            showError(inputUsername,"Your username is not valid!");
        }
        else if (email.isEmpty() || !email.contains("@")){
            showError(inputEmail,"Email is not valid");
        }
        else if (password.isEmpty() || password.length()<8){
            showError(inputPassword,"Password must be 8 character");
        }
        else if (confirmPassword.isEmpty() || !confirmPassword.equals(password)){
            showError(inputConfirmPassword,"Password not match");
        }
        else{
            Toast.makeText(this, "call Registration Method", Toast.LENGTH_SHORT).show();
        }
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}