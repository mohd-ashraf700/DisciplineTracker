package com.disciplinetracker.controller;

import com.disciplinetracker.model.HabitCompletion;
import com.disciplinetracker.service.HabitCompletionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/habit-completion")
public class HabitCompletionController {

    private final HabitCompletionService habitCompletionService;
    public HabitCompletionController(HabitCompletionService habitCompletionService){
        this.habitCompletionService = habitCompletionService;
    }

    @PostMapping("habit/{habitId}")
    public ResponseEntity<HabitCompletion> createHabitCompletion(@PathVariable Long habitId){
        HabitCompletion habitCompletionResponse = habitCompletionService.createCompletion(habitId);

        return ResponseEntity.ok(habitCompletionResponse);
    }
}
