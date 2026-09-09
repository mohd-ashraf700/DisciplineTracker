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
		System.out.println("hello mote");
		User user = new User("Md Ashraf", "9876543210", "ashraf@example.com",LocalDate.of(2025 , 8 , 5), "password123");
		user.setPhoneNumber("9352199719");
		String number = user.getPhoneNumber();
		System.out.println(number);
	}

}
