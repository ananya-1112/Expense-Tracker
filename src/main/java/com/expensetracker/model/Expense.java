package com.expensetracker.model;

import jakarta.persistence.*;   //imports JPA annotations : for java class --> db tables
import jakarta.validation.constraints.*; //for validations

import java.time.LocalDate;

@Entity //marks as JPA Entity : tells hibernate to create db tables for this class
public class Expense {

    @Id   //marks the field as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //db handles auto increment when using IDENTITY
    private Long id;   // primary key, value generated and handled by DB

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotNull(message = "Amount cannot be empty")
    @Positive(message = "Amount should be greater than 0")
    private Double amount;

    @Enumerated(EnumType.STRING) // defines the storage value types in db,
    @NotNull(message = "Category is required")
    private Category category;  // means category can have only string values and not ordinal by default

    @NotNull(message = "Date is required")
    private LocalDate date;

    // getters and setters (we’ll improve this later)

    public Long getId() {   //no setter because it is auto generated value
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

