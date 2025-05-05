package com.example.belajar_retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SpainResponse {
    @SerializedName("teams")
    private List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public static class Team {
        @SerializedName("strTeam")
        private String strTeam;

        @SerializedName("strBadge")
        private String strTeamBadge;

        public String getStrTeam() {
            return strTeam;
        }

        public void setStrTeam(String strTeam) {
            this.strTeam = strTeam;
        }

        public String getStrTeamBadge() {
            return strTeamBadge;
        }

        public void setStrTeamBadge(String strTeamBadge) {
            this.strTeamBadge = strTeamBadge;
        }
    }
}
