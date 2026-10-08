package com.disciplinetracker.service;

import com.disciplinetracker.model.Habit;
import com.disciplinetracker.model.HabitCompletion;
import com.disciplinetracker.repository.HabitCompletionRepository;
import com.disciplinetracker.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HabitCompletionService {
    private final HabitCompletionRepository habitCompletionRepository;
    private final HabitRepository habitRepository;

    public HabitCompletionService(HabitCompletionRepository habitCompletionRepository, HabitRepository habitRepository) {
        this.habitCompletionRepository = habitCompletionRepository;
        this.habitRepository = habitRepository;
    }

    public HabitCompletion createCompletion(Long habitId){
        Habit existingHabit = habitRepository.findById(habitId)
                .orElse(null);
        HabitCompletion completion = new HabitCompletion();
        completion.setHabit(existingHabit);
        completion.setCompletionDate(LocalDate.now());

        return habitCompletionRepository.save(completion);
    }

    public List<HabitCompletion> getCompletionsByHabit(Long habitId){
        return habitCompletionRepository.findByHabitHabitId(habitId);
    }
}
