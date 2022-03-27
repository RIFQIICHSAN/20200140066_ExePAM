package com.pam.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.Inet4Address;

public class MainActivity extends AppCompatActivity {
    //Variabel untuk button
    Button btnLogin, btnRegister;
    //Variabel untuk edittext
    EditText insrtnama, insrtpass;
    //Variabel untuk string
    String nama, password;
    //Variabel untuk textview
    TextView txnama, txpass;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin=findViewById(R.id.button);
        btnRegister=findViewById(R.id.register);

        insrtnama=findViewById(R.id.login_nama);
        insrtpass=findViewById(R.id.login_pass);

        txnama=findViewById(R.id.lnama);
        txpass=findViewById(R.id.lpass);

        //membuat fungsi onclik pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama =  insrtnama.getText().toString();
                password = insrtpass.getText().toString();
                String name = "Rifqi Ichsan";
                String pass = "Ican123";

                if (nama.isEmpty() && (password.isEmpty())) {
                    Toast r = Toast.makeText(getApplicationContext(),
                            "Name and Password must be written!",
                            Toast.LENGTH_LONG);
                }else {
                    if (nama.equals(name) && password.equals(pass)) {
                        Toast r = Toast.makeText(getApplicationContext(),
                                "Login Success",
                                Toast.LENGTH_LONG);
                        r.show();

                        Bundle a = new Bundle();
                        a.putString("b", nama.trim());

                        Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                        i.putExtras(i);
                        startActivity(i);
                    }else {
                        Toast r = Toast.makeText(getApplicationContext(),
                                "Login Denied",
                                Toast.LENGTH_LONG);
                        r.show();
                    }
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegisterPage.class);
                startActivity(i);
            }
        });
    }
}