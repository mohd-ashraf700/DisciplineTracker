package com.disciplinetracker.service;

import com.disciplinetracker.model.Habit;
import com.disciplinetracker.repository.HabitRepository;
import org.springframework.stereotype.Service;

@Service
public class HabitService {
    private final HabitRepository habitRepository;
    public HabitService(HabitRepository habitRepository){
        this.habitRepository = habitRepository;
    }

    public Habit createHabit(Habit habit){
        return habitRepository.save(habit);
    }
}
