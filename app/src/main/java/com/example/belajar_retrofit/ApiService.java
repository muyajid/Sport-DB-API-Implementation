package com.example.belajar_retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
//    Ini sudah saya selesaikan
    @GET("all_countries.php")
    Call<CountryResponse> getAllCountries();
// Ini belum
    @GET("search_all_teams.php?s=Soccer&c=Spain")
    Call<SpainResponse> getSpain();
}
