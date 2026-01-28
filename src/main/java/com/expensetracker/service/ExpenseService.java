package com.expensetracker.service;

import com.expensetracker.dto.ExpenseRequestDTO;
import com.expensetracker.dto.ExpenseResponseDTO;
import com.expensetracker.model.Expense;

import java.util.List;

public interface ExpenseService {

    ExpenseResponseDTO addExpense(ExpenseRequestDTO dto);

    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    void deleteExpense(Long id);
}

