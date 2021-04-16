package com.example.consumingrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferCandidate {
    private int id;
    private String name;
    private Placements placements;

    public OfferCandidate() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Placements getPlacements() {
        return placements;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlacements(Placements p) {
        this.placements.setId(p.getId());
        this.placements.setCandidate_id(p.getCandidate_id());
        this.placements.setOffer_id(p.getOffer_id());
        this.placements.setStage_id(p.getStage_id());
    }

    @Override
    public String toString() {
        return "id: " + this.id + "; " + "name: " + this.name + ", " + "placements: " + this.placements.toString();
    }
}