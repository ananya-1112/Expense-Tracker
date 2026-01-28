package com.expensetracker.dto;

import com.expensetracker.model.Category;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class ExpenseRequestDTO {

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than 0")
    private Double amount;

    @NotNull(message = "Category is required")
    private Category category;

    @NotNull(message = "Date is required")
    private LocalDate date;

    // getters and setters


    public @NotBlank(message = "Title cannot be empty") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "Title cannot be empty") String title) {
        this.title = title;
    }

    public @NotNull(message = "Amount is required") @Positive(message = "Amount must be greater than 0") Double getAmount() {
        return amount;
    }

    public void setAmount(@NotNull(message = "Amount is required") @Positive(message = "Amount must be greater than 0") Double amount) {
        this.amount = amount;
    }

    public @NotNull(message = "Category is required") Category getCategory() {
        return category;
    }

    public void setCategory(@NotNull(message = "Category is required") Category category) {
        this.category = category;
    }

    public @NotNull(message = "Date is required") LocalDate getDate() {
        return date;
    }

    public void setDate(@NotNull(message = "Date is required") LocalDate date) {
        this.date = date;
    }
}
