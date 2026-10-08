package com.disciplinetracker.controller;

import com.disciplinetracker.model.HabitCompletion;
import com.disciplinetracker.service.HabitCompletionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("habit/{habitId}")
    public ResponseEntity<List<HabitCompletion>> getCompletionByHabit(Long habitId){
        List<HabitCompletion> response = habitCompletionService.getCompletionsByHabit(habitId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/habit/{habitId}/streak")
    public ResponseEntity<Integer> getCurrentStreak(
            @PathVariable Long habitId){
        int streak = habitCompletionService.getCurrentStreak(habitId);
        return ResponseEntity.ok(streak);
    }
}
