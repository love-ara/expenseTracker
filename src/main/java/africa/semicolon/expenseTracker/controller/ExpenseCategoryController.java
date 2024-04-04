package africa.semicolon.expenseTracker.controller;

import africa.semicolon.expenseTracker.data.model.ExpenseCategory;
import africa.semicolon.expenseTracker.data.repository.ExpenseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ExpenseCategoryController {
    @Autowired
    private ExpenseCategoryRepository expenseCategoryRepository;

    @GetMapping("/category")
    public ResponseEntity<List<ExpenseCategory>> getAllExpenses(){
        return new ResponseEntity<>(expenseCategoryRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<ExpenseCategory> getExpensesByI(@PathVariable String id){
    Optional<ExpenseCategory> expenseCategory = expenseCategoryRepository.findById(id);
    return expenseCategory.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
