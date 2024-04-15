package africa.semicolon.expenseTracker.dto.response;

import lombok.Data;

@Data
public class CreateExpenseResponse {
    private String expenseId;
    private String username;
    private String description;
    private Double amount;
    private String expenseCategory;
    private String ExpenseTime;
    //private String response;
}
