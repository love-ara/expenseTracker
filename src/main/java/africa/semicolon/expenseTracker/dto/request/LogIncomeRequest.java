package africa.semicolon.expenseTracker.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LogIncomeRequest {
    private String id;
    private String incomeName;
    private BigDecimal amount;
    private String description;
    private String incomeType;
    private String date;
    private String username;
}
