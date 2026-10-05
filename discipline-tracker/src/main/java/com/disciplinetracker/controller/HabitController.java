package com.disciplinetracker.controller;

import com.disciplinetracker.model.Habit;
import com.disciplinetracker.service.HabitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/habit")
public class HabitController {
    private final HabitService habitService;
    public HabitController(HabitService habitService){
        this.habitService = habitService;
    }

    @PostMapping
    public ResponseEntity<Habit> createHabit(@RequestBody Habit habit){
        Habit habitResponse = habitService.createHabit(habit);
        return ResponseEntity.ok(habitResponse);
    }
}
