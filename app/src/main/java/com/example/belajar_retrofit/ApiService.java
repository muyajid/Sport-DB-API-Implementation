package com.example.belajar_retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("all_countries.php")
    Call<CountryResponse> getAllCountries();
}
