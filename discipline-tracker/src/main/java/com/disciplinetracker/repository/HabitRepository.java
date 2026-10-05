package com.disciplinetracker.repository;

import com.disciplinetracker.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitRepository extends JpaRepository<Habit , Long> {
    List<Habit> findByUserUserId(Long userId);
}
