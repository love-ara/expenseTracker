package africa.semicolon.expenseTracker.dto.request;

import lombok.Data;

@Data
public class CreateExpenseRequest {
    private String expenseId;
    private String username;
    private String description;
    private Double amount;
    private String expenseCategory;
    private String expenseDate;

}
