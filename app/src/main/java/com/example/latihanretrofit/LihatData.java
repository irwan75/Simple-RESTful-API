package com.example.latihanretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.latihanretrofit.API_Insert.ApiClient;
import com.example.latihanretrofit.API_Insert.DAO_Value;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LihatData extends AppCompatActivity {

    RecyclerView recyclerView;
    UserAdapter userAdapter;
    List<DAO_Value> userData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        readData();

    }

    private void readData() {
        Call<List<DAO_Value>> call = ApiClient.getInstance().getApi().getData();
        call.enqueue(new Callback<List<DAO_Value>>() {
            @Override
            public void onResponse(Call<List<DAO_Value>> call, Response<List<DAO_Value>> response) {
                userData = response.body();

                userAdapter = new UserAdapter(LihatData.this, userData);
                recyclerView.setAdapter(userAdapter);
            }

            @Override
            public void onFailure(Call<List<DAO_Value>> call, Throwable t) {
                Toast.makeText(LihatData.this, "Data Gagal Ter-input", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
