package africa.semicolon.expenseTracker.controller;

import africa.semicolon.expenseTracker.data.model.Expense;
import africa.semicolon.expenseTracker.data.repository.ExpenseRepository;
import africa.semicolon.expenseTracker.dto.request.CreateExpenseRequest;
import africa.semicolon.expenseTracker.dto.request.DeleteRequest;
import africa.semicolon.expenseTracker.dto.request.UpdateRequest;
import africa.semicolon.expenseTracker.dto.response.ApiResponse;
import africa.semicolon.expenseTracker.exceptions.ExpenseAlreadyExist;
import africa.semicolon.expenseTracker.exceptions.ExpenseNotFoundException;
import africa.semicolon.expenseTracker.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ExpenseController {
    private ExpenseRepository expenseRepository;
    private ExpenseService expenseService;

    @GetMapping("/expense")
    public ResponseEntity<List<Expense>> getAllExpenses(){
        return new ResponseEntity<>(expenseRepository.findAll(), OK);
    }
    @PostMapping("/log-expense")
    public ResponseEntity<?> logExpense(@RequestBody CreateExpenseRequest createExpenseRequest) {
        try {
            var expense = expenseService.createExpense(createExpenseRequest);
            return new ResponseEntity<>(new ApiResponse(true, expense), OK);
        } catch (ExpenseAlreadyExist e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateExpense(@RequestBody UpdateRequest updateRequest){
        try {
            var expense = expenseService.updateExpense(updateRequest);
            return new ResponseEntity<>(new ApiResponse(true, expense), OK);
        }catch (ExpenseNotFoundException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteExpense(@RequestBody DeleteRequest deleteRequest) {
        try{
            var expense = expenseService.deleteExpense(deleteRequest);
            return new ResponseEntity<>(new ApiResponse(true, expense), OK);
        }catch(ExpenseNotFoundException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }

}
