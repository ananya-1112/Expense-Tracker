package com.expensetracker.service;

import com.expensetracker.dto.ExpenseRequestDTO;
import com.expensetracker.dto.ExpenseResponseDTO;
import com.expensetracker.exception.ResourceNotFoundException;
import com.expensetracker.model.Expense;
import com.expensetracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service             //marks this as service class (spring annotations)
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;   //NEED TO SEE AGAIN !!!!

    //DOUBT : If constructor should not be created in spring, then why this line is used. should it not entirely avoid it
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public ExpenseResponseDTO addExpense(ExpenseRequestDTO dto) {
        Expense expense = new Expense();
        expense.setTitle(dto.getTitle());
        expense.setAmount(dto.getAmount());
        expense.setCategory(dto.getCategory());
        expense.setDate(dto.getDate());

        Expense saved = expenseRepository.save(expense);

        return mapToResponse(saved);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Expense not found with id " + id));
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    private ExpenseResponseDTO mapToResponse(Expense expense) {
        ExpenseResponseDTO dto = new ExpenseResponseDTO();
        dto.setId(expense.getId());
        dto.setTitle(expense.getTitle());
        dto.setAmount(expense.getAmount());
        dto.setDate(expense.getDate());
        return dto;
    }

}
