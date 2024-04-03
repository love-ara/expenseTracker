package africa.semicolon.expenseTracker.controller;

import africa.semicolon.expenseTracker.data.model.ExpenseCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseCategoryRepository extends MongoRepository<ExpenseCategory, String > {
}
