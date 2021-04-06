package com.example.kidmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnBefore,btnAfter,btnShowResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnAfter.setOnClickListener(this);
        btnBefore.setOnClickListener(this);
        btnShowResult.setOnClickListener(this);
    }

    private void init() {
        btnBefore=findViewById(R.id.btnBefore);
        btnAfter=findViewById(R.id.btnAfter);
        btnShowResult=findViewById(R.id.btnShowResult);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBefore:
                startActivity(new Intent(MainActivity.this,BeforeNumberActivity.class));
                break;
            case R.id.btnAfter:
                startActivity(new Intent(MainActivity.this,AfterNumberActivity.class));
                break;
            case R.id.btnShowResult:
                startActivity(new Intent(MainActivity.this,ShowResultActivity.class));
                break;
        }

    }
}
