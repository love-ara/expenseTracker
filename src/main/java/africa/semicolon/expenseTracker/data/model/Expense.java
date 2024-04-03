package africa.semicolon.expenseTracker.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("Expense")
public class Expense {
    @Id
    private String id;

    private Instant expenseDate;

    private String description;
    @DBRef
    private ExpenseCategory expenseCategory;

    @DBRef
    private User user;
}
