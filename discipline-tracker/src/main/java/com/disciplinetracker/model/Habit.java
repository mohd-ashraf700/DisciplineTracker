package com.disciplinetracker.model;

import java.time.LocalDate;

public class Habit {
    private long habitId;
    private static long nextHabitId = 1000;
    private String habitName;
    private String description;
    private int difficulty;
    private int estimatedTime;
    private LocalDate startingDate;

    public Habit( String habitName , String description , int difficulty , int estimatedTime , LocalDate startingDate){
        this.habitId = nextHabitId;
        nextHabitId++;
        this.habitName = habitName;
        this.description = description;
        setDifficulty(difficulty);
        setEstimatedTime(estimatedTime);
        this.startingDate = (startingDate != null) ? startingDate : LocalDate.now();
    }

    public long getHabitId() {
        return habitId;
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

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        if(difficulty >= 1 && difficulty <= 5){
            this.difficulty = difficulty;
        }
        else{
            throw new IllegalArgumentException("rating should be in between 1 to 5");
        }
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
}
