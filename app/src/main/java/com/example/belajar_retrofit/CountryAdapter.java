package com.example.belajar_retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private CountryResponse.Country[] countries;

    public CountryAdapter(CountryResponse.Country[] countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        return new CountryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        CountryResponse.Country country = countries[position];
        holder.tvtCountry.setText(country.getName());
        Glide.with(holder.imgCountry.getContext())
                .load(country.getFlagUrl())
                .into(holder.imgCountry);
    }

    @Override
    public int getItemCount() {
        return countries.length;
    }

    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView tvtCountry;
        ImageView imgCountry;

        public CountryViewHolder(View itemView) {
            super(itemView);
            tvtCountry = itemView.findViewById(R.id.tvtCountry);
            imgCountry = itemView.findViewById(R.id.imgCountry);
        }
    }
}
