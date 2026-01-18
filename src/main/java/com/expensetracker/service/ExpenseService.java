package com.expensetracker.service;

import com.expensetracker.model.Expense;

import java.util.List;

public interface ExpenseService {

    Expense addExpense(Expense expense);

    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    void deleteExpense(Long id);
}

