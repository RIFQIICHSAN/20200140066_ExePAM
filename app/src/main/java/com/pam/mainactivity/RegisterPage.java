package com.pam.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class RegisterPage extends AppCompatActivity {

    //Variabel untuk button
    Button btnRegister;
    //Variabel untuk edittext
    EditText insrtnama, insrtpass, insrtemail, insrtrepass;
    //Variabel untuk string
    String nama, password, email, repassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        btnRegister = findViewById(R.id.btnRegister);
        insrtnama = findViewById(R.id.edNama);
        insrtemail = findViewById(R.id.edEmail);
        insrtpass = findViewById(R.id.edPass);
        insrtrepass = findViewById(R.id.edRepass);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nama = insrtnama.getText().toString();
                email = insrtemail.getText().toString();
                password = insrtpass.getText().toString();
                repassword = insrtrepass.getText().toString();

                if (insrtnama.getText().toString().length()==0){
                    insrtnama.setError("Name Needed!!");
                }
                if (insrtemail.getText().toString().length()==0){
                    insrtemail.setError("Email Needed!!");
                }
                if (insrtpass.getText().toString().length()==0){
                    insrtpass.setError("Password Needed!!");
                }
                if (insrtrepass.getText().toString().length()==0){
                    insrtrepass.setError("Re-Type Password!!");
                }
                else {
                    if (insrtpass.getText().toString().equals(insrtrepass.getText().toString())){
                        Toast r = Toast.makeText(getApplicationContext(),
                                "Account has been registered", Toast.LENGTH_LONG);
                        r.show();

                        Bundle a = new Bundle();
                        a.putString("b", nama.trim());

                        Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                        i.putExtras(a);
                        startActivity(i);
                    }
                    else {
                        Snackbar.make(view, "Enter the same password!!",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}