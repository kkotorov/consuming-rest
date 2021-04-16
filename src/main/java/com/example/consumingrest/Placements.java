package com.example.consumingrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Placements {
    private int candidate_id;
    private int id;
    private int offer_id;
    private int stage_id;

    public Placements() {

    }

    public int getCandidate_id() {
        return candidate_id;
    }

    public int getId() {
        return id;
    }

    public int getOffer_id() {
        return offer_id;
    }

    public int getStage_id() {
        return stage_id;
    }

    public void setCandidate_id(int candidate_id) {
        this.candidate_id = candidate_id;
    }

    public void setId(int id) {
        this.id = id;

    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public void setStage_id(int stage_id) {
        this.stage_id = stage_id;
    }

    @Override
    public String toString() {
        return "candidate id is: " + this.candidate_id + "; " + "id is: " + this.id + "; " + "offer id is: " + this.offer_id + "; " + "stage id is: " + this.stage_id + "; " + "\n";
    }
}
