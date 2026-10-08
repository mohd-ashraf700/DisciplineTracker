package com.disciplinetracker.repository;

import com.disciplinetracker.model.HabitCompletion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitCompletionRepository extends JpaRepository<HabitCompletion , Long> {
}
