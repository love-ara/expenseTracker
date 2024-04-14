package africa.semicolon.expenseTracker.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Bill {
    @Id
    private String id;
    private String billName;
    private Double amount;
    private String dueDate;
    private String frequency;

}
