package com.example.belajar_retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class SpainAdapter extends RecyclerView.Adapter<SpainAdapter.SpainViewHolder> {

    private Context context;
    private List<SpainResponse.Team> listTeams;

    public SpainAdapter(Context context, List<SpainResponse.Team> listTeams) {
        this.context = context;
        this.listTeams = listTeams;
    }

    @NonNull
    @Override
    public SpainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_spain, parent, false);
        return new SpainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpainViewHolder holder, int position) {
        SpainResponse.Team team = listTeams.get(position);
        holder.tvTeam.setText(team.getStrTeam());
        // Memastikan URL gambar valid
        Glide.with(context)
                .load(team.getStrTeamBadge())
                .into(holder.imgTeam);
    }

    @Override
    public int getItemCount() {
        return listTeams != null ? listTeams.size() : 0;
    }

    public static class SpainViewHolder extends RecyclerView.ViewHolder {
        TextView tvTeam;
        ImageView imgTeam;

        public SpainViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTeam = itemView.findViewById(R.id.tvTeam);
            imgTeam = itemView.findViewById(R.id.imgTeam);
        }
    }
}
