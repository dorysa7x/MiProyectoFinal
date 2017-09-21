package com.example.dorys.proyectos;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button continuar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continuar=(Button)findViewById(R.id.btn);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent continuar=new Intent(MainActivity.this, Main2Activity.class);
                startActivity(continuar);
            }
        });


    }
}
