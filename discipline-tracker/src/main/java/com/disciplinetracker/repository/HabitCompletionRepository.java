package com.disciplinetracker.repository;

import com.disciplinetracker.model.HabitCompletion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitCompletionRepository extends JpaRepository<HabitCompletion , Long> {
    List<HabitCompletion> findByHabitHabitId(Long habitId);
}
