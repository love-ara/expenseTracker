package africa.semicolon.expenseTracker.controller;

import africa.semicolon.expenseTracker.data.model.Expense;
import africa.semicolon.expenseTracker.data.model.ExpenseCategory;
import africa.semicolon.expenseTracker.data.repository.ExpenseRepository;
import africa.semicolon.expenseTracker.dto.request.CreateExpenseRequest;
import africa.semicolon.expenseTracker.dto.response.ApiResponse;
import africa.semicolon.expenseTracker.exceptions.ExpenseAlreadyExist;
import africa.semicolon.expenseTracker.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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
//    @PostMapping("/category")
//    public ResponseEntity<?> createExpenses(@Validated @RequestBody ExpenseCategory expenseCategory) throws URISyntaxException {
//            ExpenseCategory result = expenseRepository.save(expenseCategory);
//            return ResponseEntity.created(new URI("/api/category" + result.getId())).body(result);
//    }
//    @PutMapping("/category/{id}")
//    public ResponseEntity<ExpenseCategory> updateExpenseCategory(@Validated @RequestBody ExpenseCategory expenseCategory){
//        //ExpenseCategory result = expenseCategoryRepository.save(expenseCategory);
//        //return ResponseEntity.ok().body(result);
//    }
//    @DeleteMapping("/category/{id}")
//    public ResponseEntity<?> deleteExpenseCategory(@PathVariable String id){
//        expenseRepository.deleteById(id);
//        return ResponseEntity.ok().build();
//    }

}
