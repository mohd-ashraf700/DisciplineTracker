package com.disciplinetracker.service;

import com.disciplinetracker.model.Habit;
import com.disciplinetracker.model.User;
import com.disciplinetracker.repository.HabitRepository;
import com.disciplinetracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {
    private final HabitRepository habitRepository;
    private final UserRepository userRepository;
    public HabitService(HabitRepository habitRepository , UserRepository userRepository, UserRepository userRepository1){
        this.habitRepository = habitRepository;
        this.userRepository = userRepository1;
    }

    public Habit createHabit(Long userId, Habit habit){
        User user = userRepository.findById(userId)
                .orElse(null);
        habit.setUser(user);
        return habitRepository.save(habit);
    }

    public Habit getHabitById(Long id){
        return habitRepository.findById(id)
                .orElse(null);
    }

    public List<Habit> getAllHabitByUser(Long userId) {
        return habitRepository.findByUserUserId(userId);
    }

    public Habit updateHabit(Long habitId , Habit updatedHabit){
        Habit existingHabit = habitRepository.findById(habitId)
                .orElse(null);
        existingHabit.setHabitName(updatedHabit.getHabitName());
        existingHabit.setDescription(updatedHabit.getDescription());
        existingHabit.setDifficulty(updatedHabit.getDifficulty());
        existingHabit.setEstimatedTime(updatedHabit.getEstimatedTime());
        return habitRepository.save(existingHabit);
    }

    public void deleteHabit(Long habitId) {
        habitRepository.deleteById(habitId);
    }
}
