package africa.semicolon.expenseTracker.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LogIncomeResponse {
    private String id;
    private String incomeName;
    private BigDecimal amount;
    private String description;
    private String incomeType;
    private String date;
}
