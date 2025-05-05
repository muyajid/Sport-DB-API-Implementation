package com.example.belajar_retrofit;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity3 extends AppCompatActivity {

    private RecyclerView rvSpain;
    private SpainAdapter spainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        rvSpain = findViewById(R.id.rvSpain);
        rvSpain.setLayoutManager(new LinearLayoutManager(MainActivity3.this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/api/v1/json/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<SpainResponse> call = apiService.getSpain();
        call.enqueue(new Callback<SpainResponse>() {
            @Override
            public void onResponse(Call<SpainResponse> call, Response<SpainResponse> response) {
                if (response.isSuccessful()) {
                    SpainResponse spainResponse = response.body();
                    if (spainResponse != null && spainResponse.getTeams() != null) {
                        spainAdapter = new SpainAdapter(MainActivity3.this, spainResponse.getTeams());
                        rvSpain.setAdapter(spainAdapter);
                    } else {
                        Toast.makeText(MainActivity3.this, "No teams found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.e("API Error", "Response Unsuccessful");
                    Toast.makeText(MainActivity3.this, "Error in API response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SpainResponse> call, Throwable t) {
                Log.e("API Error", t.getMessage());
                Toast.makeText(MainActivity3.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
