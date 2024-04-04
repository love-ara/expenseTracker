package africa.semicolon.expenseTracker.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Category")
public class ExpenseCategory {
    @Id
    private String id;
    private String categoryName;

}
