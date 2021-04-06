package com.example.kidmath;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.kidmath.databse.AppDataBase;
import com.example.kidmath.databse.User;
import com.luolc.emojirain.EmojiRainLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AfterNumberActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtAfterNumber;
    private TextView tvRandom,tvTotalDisplay,tvQuestionNumber;
    private ImageView ivEmoji;
    private Button btnBack,btnNext;
    private ArrayList<Boolean> list;
    private int i=1,total=0;
    private User user;
    private Date todayDate;
    SimpleDateFormat formatter;
    String todayString;
    EmojiRainLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_number);
        init();
        openKeyBoard();
        btnNext.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }
    private void openKeyBoard()
    {
        edtAfterNumber.requestFocus();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

    }
    private void init() {
        btnBack=findViewById(R.id.btnBack);
        edtAfterNumber=findViewById(R.id.edtAfterNumber);
        btnNext=findViewById(R.id.btnNext);
        tvRandom=findViewById(R.id.tvRandom);
        list=new ArrayList<>();
        tvTotalDisplay=findViewById(R.id.tvTotalDisplay);
        ivEmoji=findViewById(R.id.ivEmoji);
        tvQuestionNumber=findViewById(R.id.tvQuestionNumber);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnNext:
                if(i<=10){
                    checkOutputAndSetResult();
                    setTextRandom();
                }
                break;
            case R.id.btnBack:
                onBackPressed();
                break;
        }
    }

    private void checkOutputAndSetResult() {
        if(!edtAfterNumber.getText().toString().isEmpty()){
            boolean check= Integer.parseInt(edtAfterNumber.getText().toString())==Integer.parseInt(tvRandom.getText().toString())+1;
            list.add(check);
        }
        if(i==10){
            btnNext.setEnabled(false);
            showResult();
            insertDataInTable();
        }
        i++;
    }

    @SuppressLint("SimpleDateFormat")
    private void insertDataInTable() {
         todayDate = Calendar.getInstance().getTime();
         formatter = new SimpleDateFormat("yyyy-MM-dd");
         todayString = formatter.format(todayDate);
        user=new User(total,todayString,"After Number");
        AppDataBase.getAppDatabase(this).userDao().insertAll(user);
        Toast.makeText(this,"data inserted successfully in table",Toast.LENGTH_LONG).show();
    }

    private void showResult() {
        for(Boolean b:list){
            if(b){
                total+=1;
            }

        }
        Log.d("___@___",total+"out of ten ");
        Intent intent=new Intent(AfterNumberActivity.this,ShowEmojiActivity.class);
        intent.putExtra("total",String.valueOf(total));
        startActivity(intent);
        finish();

    }


    private void setTextRandom() {
        tvQuestionNumber.setText("Que :"+i);
        tvRandom.setText(String.valueOf(getRandomNumber()));
        edtAfterNumber.setText("");
    }

    private int getRandomNumber() {
        double num=Math.random()*20;
        int number=(int)num ;
        if(number==0){
            number+=1;
        }
        return number;
    }
}
