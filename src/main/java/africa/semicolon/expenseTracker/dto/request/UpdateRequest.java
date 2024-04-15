package africa.semicolon.expenseTracker.dto.request;

import lombok.Data;

@Data
public class UpdateRequest {
    private String id;
    private String description;
    private Double amount;
    private String expenseCategory;
    private String username;
    private String expenseDate;
}
