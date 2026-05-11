package com.phloon.tracker.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int reps;
    private double weight;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    public Exercise() {}

    public Exercise(String name, int reps, double weight) {
        this.name = name;
        this.reps = reps;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getReps() {
        return reps;
    }

    public double getWeight() {
        return weight;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }
}