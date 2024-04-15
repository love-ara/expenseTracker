package africa.semicolon.expenseTracker.data.repository;

import africa.semicolon.expenseTracker.data.model.Income;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends MongoRepository<Income, String> {
}
