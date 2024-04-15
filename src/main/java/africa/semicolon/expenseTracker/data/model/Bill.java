package africa.semicolon.expenseTracker.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document("bills")
public class Bill {
    @Id
    private String id;
    private String billName;
    private BigDecimal amount = BigDecimal.valueOf(0);
    private LocalDateTime dueDate;
    private Frequency frequency;
    @DBRef
    private User user;
}
