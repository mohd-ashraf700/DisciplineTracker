package com.disciplinetracker.controller;

import com.disciplinetracker.model.Habit;
import com.disciplinetracker.service.HabitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/habit")
public class HabitController {
    private final HabitService habitService;
    public HabitController(HabitService habitService){
        this.habitService = habitService;
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<Habit> createHabit(@PathVariable Long userId ,
            @RequestBody Habit habit){
        Habit habitResponse = habitService.createHabit(userId ,habit);
        return ResponseEntity.ok(habitResponse);
    }

    @GetMapping("/{habitId}")
    public ResponseEntity<Habit> getHabitById(@PathVariable Long habitId){
        Habit habitResponse = habitService.getHabitById(habitId);
        return ResponseEntity.ok(habitResponse);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Habit>> getAllHabits(
            @PathVariable Long userId) {

        List<Habit> habitsResponse =
                habitService.getAllHabitByUser(userId);

        return ResponseEntity.ok(habitsResponse);
    }

    @PutMapping("/{habitId}")
    public ResponseEntity<Habit> updateHabit(@PathVariable Long habitId
    , @RequestBody Habit updatedHabit){
        Habit updatedHabitResponse = habitService.updateHabit(habitId , updatedHabit);
        return ResponseEntity.ok(updatedHabitResponse);
    }
}
