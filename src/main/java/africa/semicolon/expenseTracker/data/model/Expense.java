package africa.semicolon.expenseTracker.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Document("Expense")
public class Expense {
    @Id
    private String id;
    private String description;
    private BigDecimal amount;
    @Field("Expense Category")
    private ExpenseCategory expenseCategory;
    @DBRef
    private User user;
    private LocalDate expenseDate = LocalDate.now();
}
