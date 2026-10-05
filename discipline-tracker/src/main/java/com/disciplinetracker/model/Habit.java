package com.disciplinetracker.model;

import com.disciplinetracker.HabitDifficulty;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long habitId;
    private String habitName;
    private String description;
    @Enumerated(EnumType.STRING)
    private HabitDifficulty difficulty;
    private int estimatedTime;
    private LocalDate startingDate;

    @ManyToOne
    private User user;

    public Long getHabitId() {
        return habitId;
    }

    public void setHabitId(Long habitId) {
        this.habitId = habitId;
    }

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HabitDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(HabitDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
