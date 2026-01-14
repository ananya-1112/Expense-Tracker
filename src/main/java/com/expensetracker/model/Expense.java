package com.expensetracker.model;

import jakarta.persistence.*;   //imports JPA annotations : for java class --> db tables
import java.time.LocalDate;

@Entity            //marks as JPA Entity : tells hibernate to create db tables for this class
public class Expense {

    @Id   //marks the field as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //db handles auto increment when using IDENTITY
    private Long id;   // primary key, value generated and handled by DB

    private String title;
    private Double amount;

    @Enumerated(EnumType.STRING) // defines the storage value types in db,
    private Category category;  // means category can have only string values and not ordinal by default

    private LocalDate date;

    // getters and setters (we’ll improve this later)
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

