package com.example.latihanretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androidnetworking.model.Progress;
import com.example.latihanretrofit.API_Insert.ApiClient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText et_title, et_nama, et_note;
    Button btn_kirim, btn_lihatData;

    ProgressDialog progressDialog;

    String title, nama, note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_title = findViewById(R.id.title);
        et_nama = findViewById(R.id.nama);
        et_note = findViewById(R.id.note);
        btn_kirim = findViewById(R.id.btnKirim);
        btn_lihatData = findViewById(R.id.lihatData);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait....");

        btn_kirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                title = et_title.getText().toString().trim();
                nama = et_nama.getText().toString().trim();
                note = et_note.getText().toString().trim();
                if(title.equals("")){
                    et_title.setError("Title Masih Kosong");
                }else if (nama.equals("")){
                    et_nama.setError("Nama Masih Kosong");
                }else if (note.equals("")){
                    et_note.setError("Note Masih Kosong");
                }else{
                    progressDialog.show();
                    insertData(title, nama, note);
                }
            }
        });

        btn_lihatData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LihatData.class);
                startActivity(intent);
            }
        });

    }

    private void insertData(String title, String nama, String note) {
        Call<ResponseBody> call = ApiClient.getInstance().getApi().insertDataa(title, nama, note);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                progressDialog.dismiss();
//                String message = response.message();
                Toast.makeText(MainActivity.this, "Data Berhasil Ter-input", Toast.LENGTH_SHORT).show();
                clearEditText();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Data Gagal Ter-input", Toast.LENGTH_SHORT).show();
                clearEditText();
            }
        });
    }

    private void clearEditText(){
        et_title.setText("");
        et_nama.setText("");
        et_note.setText("");
    }
}
