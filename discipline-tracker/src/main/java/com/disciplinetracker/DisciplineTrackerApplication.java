package com.disciplinetracker;

import com.disciplinetracker.model.User;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class DisciplineTrackerApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DisciplineTrackerApplication.class, args);
	}

}
