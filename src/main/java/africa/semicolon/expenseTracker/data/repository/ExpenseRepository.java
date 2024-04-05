package africa.semicolon.expenseTracker.data.repository;

import africa.semicolon.expenseTracker.data.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {

}
