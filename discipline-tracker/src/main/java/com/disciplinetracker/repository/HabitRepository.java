package com.disciplinetracker.repository;

import com.disciplinetracker.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<Habit , Long> {
}
