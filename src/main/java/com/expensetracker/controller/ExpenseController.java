package com.expensetracker.controller;

import com.expensetracker.model.Expense;
import com.expensetracker.service.ExpenseService;
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
    public Expense addExpense(@RequestBody Expense expense) {  //@RequestBody converts JSON to Expense object
        return expenseService.addExpense(expense);
    }

    // GET - get all expenses
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
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
