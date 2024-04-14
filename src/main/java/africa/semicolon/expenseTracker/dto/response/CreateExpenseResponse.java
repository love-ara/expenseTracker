package africa.semicolon.expenseTracker.dto.response;

import africa.semicolon.expenseTracker.data.model.ExpenseCategory;
import lombok.Data;

@Data
public class CreateExpenseResponse {
    private String expenseId;
    private String username;
    private String description;
    private Double amount;
    private ExpenseCategory expenseCategory;
    private String ExpenseTime;
    //private String response;
}
