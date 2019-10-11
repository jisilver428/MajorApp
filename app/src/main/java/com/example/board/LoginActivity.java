package com.example.board;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class LoginActivity extends AppCompatActivity {
    SQLiteDatabase sqlliteDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sqlliteDB=init_database();

        TextView registerButton= (TextView)findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent registerIntent=new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });
    }

    private SQLiteDatabase init_database(){
        SQLiteDatabase db=null;
        File file=new File(getFilesDir(), "contact.db");
        System.out.println("PATH: "+file.toString());
        try{
            db=SQLiteDatabase.openOrCreateDatabase(file,null);

        }catch (SQLException e){
            e.printStackTrace();
        }
        if (db==null){
            System.out.println("DB creation fail."+file.getAbsolutePath());
        }
        return db;
    }
}
