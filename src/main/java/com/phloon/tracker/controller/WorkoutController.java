package com.phloon.tracker.controller;

import com.phloon.tracker.model.Workout;
import com.phloon.tracker.repository.WorkoutRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import com.phloon.tracker.model.Exercise;
import com.phloon.tracker.repository.ExerciseRepository;
import java.util.Optional;
@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    private final WorkoutRepository workoutRepository;
    private final ExerciseRepository exerciseRepository;

    public WorkoutController(
            WorkoutRepository workoutRepository,
            ExerciseRepository exerciseRepository
    ) {
        this.workoutRepository = workoutRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @PostMapping
    public Workout createWorkout(@RequestBody Workout workout) {
        return workoutRepository.save(workout);
    }

    @GetMapping
    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    @PostMapping("/{workoutId}/exercises")
    public Exercise addExerciseToWorkout(
            @PathVariable Long workoutId,
            @RequestBody Exercise exercise
    ) {
        Optional<Workout> optionalWorkout = workoutRepository.findById(workoutId);

        if (optionalWorkout.isEmpty()) {
            throw new RuntimeException("Workout not found");
        }

        Workout workout = optionalWorkout.get();

        exercise.setWorkout(workout);
        workout.getExercises().add(exercise);
        return exerciseRepository.save(exercise);
    }
}