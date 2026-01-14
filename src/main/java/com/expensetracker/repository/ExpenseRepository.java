package com.expensetracker.repository;

import com.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//Spring Data JPA generates the repository implementation at runtime, so we only define an interface.
// !!!!NEED TO LEARN MORE ABOUT THIS LINE AND TRADITIONAL DB INTERACTION AS WELL.
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
