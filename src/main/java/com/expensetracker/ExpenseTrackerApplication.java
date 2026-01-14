package com.expensetracker;

import com.expensetracker.model.Category;
import com.expensetracker.model.Expense;
import com.expensetracker.repository.ExpenseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class ExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}

	@Bean
	CommandLineRunner testRepository(ExpenseRepository expenseRepository) {
		return args -> {
			Expense expense = new Expense();
			expense.setTitle("Lunch");
			expense.setAmount(250.0);
			expense.setCategory(Category.ONLINEFOOD);
			expense.setDate(LocalDate.now());

			expenseRepository.save(expense);

			expenseRepository.findAll()
					.forEach(e -> System.out.println("Saved Expense: " + e.getTitle()));
		};
	}
}
