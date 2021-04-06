package com.example.kidmath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.example.kidmath.adapter.ItemHistoryAdapter;
import com.example.kidmath.databse.AppDataBase;
import com.example.kidmath.databse.User;

import java.util.ArrayList;
import java.util.List;

public class ShowResultActivity extends AppCompatActivity {

    private RecyclerView rvItemHistory;
    private LinearLayoutManager linearLayoutManager;
    List<User> arrayList;
    private ItemHistoryAdapter itemHistoryAdapter;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        init();
       arrayList= AppDataBase.getAppDatabase(this).userDao().getAll();
       for (User user:arrayList){
           Log.d("___@___",user.getDate()+user.getTypeOfTest());}
       itemHistoryAdapter=new ItemHistoryAdapter(this,arrayList);
       rvItemHistory.setAdapter(itemHistoryAdapter);
       btnBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               onBackPressed();
           }
       });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void init() {
        rvItemHistory=findViewById(R.id.rvItemHistory);
        linearLayoutManager=new LinearLayoutManager(this);
        rvItemHistory.setLayoutManager(linearLayoutManager);
        btnBack=findViewById(R.id.btnBack);
    }
}
