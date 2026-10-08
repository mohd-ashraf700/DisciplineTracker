package com.disciplinetracker.service;

import com.disciplinetracker.model.Habit;
import com.disciplinetracker.model.HabitCompletion;
import com.disciplinetracker.repository.HabitCompletionRepository;
import com.disciplinetracker.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class HabitCompletionService {
    private final HabitCompletionRepository habitCompletionRepository;
    private final HabitRepository habitRepository;

    public HabitCompletionService(HabitCompletionRepository habitCompletionRepository, HabitRepository habitRepository) {
        this.habitCompletionRepository = habitCompletionRepository;
        this.habitRepository = habitRepository;
    }

    public HabitCompletion createCompletion(Long habitId){
        LocalDate today = LocalDate.now();
        Habit existingHabit = habitRepository.findById(habitId)
                .orElseThrow(() -> new RuntimeException("Habit not found"));
        Optional<HabitCompletion> existing =
                habitCompletionRepository
                        .findByHabitHabitIdAndCompletionDate(habitId, today);
        if(existing.isEmpty()){
            HabitCompletion completion = new HabitCompletion();
            completion.setHabit(existingHabit);
            completion.setCompletionDate(today);
            return habitCompletionRepository.save(completion);
        }
        throw new RuntimeException("Habit already completed today");
    }

    public List<HabitCompletion> getCompletionsByHabit(Long habitId){
        return habitCompletionRepository.findByHabitHabitIdOrderByCompletionDateDesc(habitId);
    }

    public int getCurrentStreak(Long habitId){
        List<HabitCompletion> completions = getCompletionsByHabit(habitId);
        if(completions.isEmpty()){
            return 0;
        }
        LocalDate today = LocalDate.now();
        if(!completions.get(0).getCompletionDate().equals(today)){
            return 0;
        }
        int streak = 1;
        for (int i = 1; i < completions.size(); i++){
            LocalDate previous = completions.get(i - 1).getCompletionDate();
            LocalDate current = completions.get(i).getCompletionDate();

            long diff = ChronoUnit.DAYS.between(current , previous);
            if(diff == 1){
                streak++;
            }else{
                break;
            }
        }
        return streak;
    }
}
