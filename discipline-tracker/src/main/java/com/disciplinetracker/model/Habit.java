package com.disciplinetracker.model;

import java.time.LocalDate;

public class Habit {
    private long habitId;
    private String habitName;
    private String description;
    private int difficulty;
    private int estimatedTime;
    private LocalDate startingDate;
}
