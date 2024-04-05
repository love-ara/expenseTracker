package africa.semicolon.expenseTracker.dto.request;

import lombok.Data;

@Data
public class ExpenseRequest {
    public String username;
    public String date;
    public String expenseCategory;
    public String description;
    public String amount;
}
