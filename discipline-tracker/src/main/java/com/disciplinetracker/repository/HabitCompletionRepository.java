package com.disciplinetracker.repository;

import com.disciplinetracker.model.HabitCompletion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HabitCompletionRepository extends JpaRepository<HabitCompletion , Long> {
    Optional<HabitCompletion> findByHabitHabitIdAndCompletionDate(
            Long habitId,
            LocalDate completionDate
    );

    List<HabitCompletion> findByHabitHabitIdOrderByCompletionDateDesc(Long habitId);
}
