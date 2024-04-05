package africa.semicolon.expenseTracker.data.repository;

import africa.semicolon.expenseTracker.data.model.ExpenseCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseCategoryRepository extends MongoRepository<ExpenseCategory, String>{

    ExpenseCategory findExpenseCategoriesByCategoryName(String categoryName);

}
