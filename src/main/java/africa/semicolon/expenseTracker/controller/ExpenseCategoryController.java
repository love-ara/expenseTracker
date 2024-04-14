//package africa.semicolon.expenseTracker.controller;
//
//import africa.semicolon.expenseTracker.data.model.ExpenseCategory;
//import africa.semicolon.expenseTracker.data.repository.ExpenseRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api")
//public class ExpenseCategoryController {
//    @Autowired
//    private ExpenseRepository expenseCategoryRepository;
//
//    @GetMapping("/category")
//    public ResponseEntity<List<ExpenseCategory>> getAllExpenses(){
//        return new ResponseEntity<>(expenseCategoryRepository.findAll(), HttpStatus.OK);
//    }
//    @GetMapping("/category/{id}")
//    public ResponseEntity<ExpenseCategory> getExpensesByI(@PathVariable String id){
//    Optional<ExpenseCategory> expenseCategory = expenseCategoryRepository.findById(id);
//    return expenseCategory.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//    @PostMapping("/category")
//    public ResponseEntity<ExpenseCategory> createExpenses(@Validated @RequestBody ExpenseCategory expenseCategory) throws URISyntaxException {
//            ExpenseCategory result = expenseCategoryRepository.save(expenseCategory);
//            return ResponseEntity.created(new URI("/api/category" + result.getId())).body(result);
//    }
//    @PutMapping("/category/{id}")
//    public ResponseEntity<ExpenseCategory> updateExpenseCategory(@Validated @RequestBody ExpenseCategory expenseCategory){
//        //ExpenseCategory result = expenseCategoryRepository.save(expenseCategory);
//        //return ResponseEntity.ok().body(result);
//    }
//    @DeleteMapping("/category/{id}")
//    public ResponseEntity<?> deleteExpenseCategory(@PathVariable String id){
//        expenseCategoryRepository.deleteById(id);
//        return ResponseEntity.ok().build();
//    }
//
//}
