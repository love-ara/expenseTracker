package africa.semicolon.expenseTracker.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document("Budget")
public class Budget {
    private String id;
    private String budgetName;
    private BudgetCategory category;
    private String description;
    private BigDecimal amount;
    private LocalDateTime startDate = LocalDateTime.now();
    private LocalDateTime endDate;
}
