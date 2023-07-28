package com.example.football.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "stats")
public class Stat extends BaseEntity{

    private float shooting;
    private float passing;
    private float endurance;

    private Player player;


    public Stat() {
    }
    @Column(nullable = false)
    public float getShooting() {
        return shooting;
    }

    public void setShooting(float shooting) {
        this.shooting = shooting;
    }
    @Column(nullable = false)
    public float getPassing() {
        return passing;
    }

    public void setPassing(float passing) {
        this.passing = passing;
    }
    @Column(nullable = false)
    public float getEndurance() {
        return endurance;
    }

    public void setEndurance(float endurance) {
        this.endurance = endurance;
    }

    @OneToOne(mappedBy = "stat", cascade = CascadeType.ALL)
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
