package com.expensetracker.controller;

import com.expensetracker.dto.ExpenseRequestDTO;
import com.expensetracker.dto.ExpenseResponseDTO;
import com.expensetracker.model.Expense;
import com.expensetracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController    //@Controller+@ResponseBody (automatically converts java to JSON)
@RequestMapping("/api/expenses")  //defines the base url for all APIs in this controller
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // POST - add expense
    @PostMapping
    public ExpenseResponseDTO addExpense(@Valid @RequestBody ExpenseRequestDTO dto) {  //@RequestBody converts JSON to Expense object
        return expenseService.addExpense(dto);

    }

    // GET - get all expenses
    @GetMapping
    public Page<ExpenseResponseDTO> getAllExpenses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return expenseService.getAllExpenses(page, size);
    }

    // GET - get expense by id
    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {  //@PathVariable extracts value from URL
        return expenseService.getExpenseById(id);
    }

    // DELETE - delete expense
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }



}
