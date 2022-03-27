package com.pam.mainactivity;

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

public class MainActivity2 extends AppCompatActivity {
    EditText ntask, jtask, ttask;
    FloatingActionButton btn;
    String task, jenis, time;
    TextView namauser;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.submit)
        task = ntask.getText().toString();
        jenis = jtask.getText().toString();
        time = ttask.getText().toString();

        if (ntask.getText().toString().length()==0){
            ntask.setError("Task Diperlukan!!");
        }
        if (jtask.getText().toString().length()==0) {
            jtask.setError("Jenis Task Diperlukan!!");
        }
        if (ttask.getText().toString().length()==0) {
            ttask.setError("Time Task Diperlukan!!");
        }
        if (task.isEmpty() || jenis.isEmpty() || time.isEmpty()) {
            Toast r = Toast.makeText(getApplicationContext(),
                    "Enter All Data!!!", Toast.LENGTH_LONG);
            r.show();
        }else {
            Toast r = Toast.makeText(getApplicationContext(),
                    "Success", Toast.LENGTH_LONG);
            r.show();

            Bundle a =new Bundle();

            a.putString("a", task.trim());
            a.putString("b", jenis.trim());
            a.putString("c", time.trim());
            Intent i = new Intent(getApplicationContext(), ResultPage.class);
            i.putExtras(a);
            startActivity(i);
        }
        if (item.getItemId()== R.id.btnlogout) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ntask = findViewById(R.id.namatask);
        jtask = findViewById(R.id.jenistask);
        ttask  = findViewById(R.id.timetask);
        namauser = findViewById(R.id.username);

        Bundle bundle = getIntent().getExtras();

        String user = bundle.getString("a");
        namauser.setText(user);

        btn = findViewById(R.id.floatingActionButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                task = ntask.getText().toString();
                jenis = jtask.getText().toString();
                time = ttask.getText().toString();

                if (task.isEmpty() || jenis.isEmpty() || time.isEmpty()) {
                    Snackbar.make(view, "Isi semuda Data!", Snackbar.LENGTH_LONG).show();
                } else {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Success", Toast.LENGTH_LONG);
                    t.show();

                    Bundle b = new Bundle();

                    b.putString("a", task.trim());
                    b.putString("b", jenis.trim());
                    b.putString("c", time.trim());
                    Intent i = new Intent(getApplicationContext(), ResultPage.class);
                    i.putExtras(b);
                    startActivity(i);
                }
            }
        });
    }
}