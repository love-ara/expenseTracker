package africa.semicolon.expenseTracker.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Document("FinancialGoals")
public class FinancialGoals {
    private String id;
    private String description;
    private BigDecimal amount;
    private LocalDate targetDate;

    @DBRef
    private User user;


}
