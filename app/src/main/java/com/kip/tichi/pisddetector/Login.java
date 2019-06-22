package com.kip.tichi.pisddetector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
    EditText pass, user;
    String username, password;
    protected void onCreate(Bundle SavedInstance) {

        super.onCreate(SavedInstance);
        setContentView(R.layout.login);

        pass=(EditText)findViewById(R.id.editPass);
        user=(EditText)findViewById(R.id.editUser);


    }


    public void cancel(View view){
        finish();
    }
    public void login(View view) {
        username=user.getText().toString();
        password=pass.getText().toString();

        if (username.isEmpty()) {
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            user.requestFocus();
        } else if (password.isEmpty()) {
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            pass.requestFocus();
        }else if (username.equals("vggs")&& password.equals("1234")) {
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }else if(username!="vggs"||password!="1234") {
            Toast.makeText(this, "wrong password or username", Toast.LENGTH_SHORT).show();
            pass.setText("");
            user.setText("");
            pass.requestFocus();
        }
    }
}
