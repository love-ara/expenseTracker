package africa.semicolon.expenseTracker.dto.request;

import africa.semicolon.expenseTracker.data.model.ExpenseCategory;
import lombok.Data;

@Data
public class CreateExpenseRequest {
    private String expenseId;
    private String username;
    private String description;
    private Double amount;
    private ExpenseCategory expenseCategory;
    private String expenseDate;

}
