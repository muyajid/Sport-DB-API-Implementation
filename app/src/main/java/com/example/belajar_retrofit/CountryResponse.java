package com.example.belajar_retrofit;
import com.google.gson.annotations.SerializedName;
public class CountryResponse {
    @SerializedName("countries")
    private Country[] countries;

    public Country[] getCountries() {
        return countries;
    }

    public void setCountries(Country[] countries) {
        this.countries = countries;
    }

    public static class Country {
        @SerializedName("name_en") // Nama negara
        private String name;

        @SerializedName("flag_url_32") // URL gambar bendera
        private String flagUrl;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFlagUrl() {
            return flagUrl;
        }

        public void setFlagUrl(String flagUrl) {
            this.flagUrl = flagUrl;
        }
    }
}
