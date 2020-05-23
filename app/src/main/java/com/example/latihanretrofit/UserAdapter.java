package com.example.latihanretrofit;

import android.content.Context;
import android.service.autofill.UserData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.latihanretrofit.API_Insert.DAO_Value;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.RecyclerHolder> {

    Context context;
    List<DAO_Value> userData;

    public UserAdapter(Context context, List<DAO_Value> userData) {
        this.context = context;
        this.userData = userData;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        DAO_Value user = userData.get(position);
        holder.tvId.setText(String.valueOf(user.getId()));
        holder.tvTitle.setText(String.valueOf(user.getTitle()));
        holder.tvNama.setText(String.valueOf(user.getNama()));
        holder.tvNote.setText(String.valueOf(user.getTitle()));
    }

    @Override
    public int getItemCount() {
        return userData.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder{

        TextView tvId, tvTitle, tvNama, tvNote;

        RecyclerHolder(@NonNull View itemView){
            super(itemView);

            tvId = itemView.findViewById(R.id.tvId);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNote = itemView.findViewById(R.id.tvNote);

        }
    }

}
