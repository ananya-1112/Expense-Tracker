package com.expensetracker;

import com.expensetracker.dto.ExpenseRequestDTO;
import com.expensetracker.model.Category;
import com.expensetracker.model.Expense;
import com.expensetracker.service.ExpenseService;
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
	CommandLineRunner testService(ExpenseService expenseService) {
		return args -> {

			ExpenseRequestDTO dto = new ExpenseRequestDTO();
			dto.setTitle("Dinner");
			dto.setAmount(350.0);
			dto.setCategory(Category.ONLINEFOOD);
			dto.setDate(LocalDate.now());

			expenseService.addExpense(dto);

			expenseService.getAllExpenses()
				.forEach(e -> System.out.println("Saved Expense: " + e.getTitle()));
		};
	}

}
