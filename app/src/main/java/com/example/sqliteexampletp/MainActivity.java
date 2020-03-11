package com.example.sqliteexampletp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText name,loc,Designation;
Button btnSave;
Intent mIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.txtName);
        loc=findViewById(R.id.txtLocation);
        Designation=findViewById(R.id.txtDesignation);
        btnSave=findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=name.getText().toString()+"\n";
                String location=loc.getText().toString();
                String designation=Designation.getText().toString();
                DbHandler dbHandler=new DbHandler(MainActivity.this);
                dbHandler.insertUserDetails(username,location,designation);
                mIntent=new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(mIntent);
                Toast.makeText(getApplicationContext(),"insertion successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
