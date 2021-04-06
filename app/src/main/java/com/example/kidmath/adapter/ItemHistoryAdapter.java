package com.example.kidmath.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kidmath.R;
import com.example.kidmath.databse.User;

import java.util.List;


public class ItemHistoryAdapter extends RecyclerView.Adapter<ItemHistoryAdapter.HistoryHolder> {

    private Context context;
    private List<User> arrayList;

    public ItemHistoryAdapter(Context context, List<User> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history,parent,false);
        return new HistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder holder, int position) {
            holder.tvTestType.setText(arrayList.get(position).getTypeOfTest());
            holder.tvDate.setText(arrayList.get(position).getDate());
            holder.tvMarks.setText(String.valueOf(arrayList.get(position).getMarks()));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class  HistoryHolder extends RecyclerView.ViewHolder{
        TextView tvTestType,tvMarks,tvDate;
        public HistoryHolder(@NonNull View itemView) {
            super(itemView);
            tvTestType=itemView.findViewById(R.id.tvTestType);
            tvMarks=itemView.findViewById(R.id.tvMarks);
            tvDate=itemView.findViewById(R.id.tvDate);
        }
    }
}
