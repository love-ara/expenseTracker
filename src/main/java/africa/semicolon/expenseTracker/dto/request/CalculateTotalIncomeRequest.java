package africa.semicolon.expenseTracker.dto.request;

import lombok.Data;

@Data
public class CalculateTotalIncomeRequest {
    private String id;
    private String specificPeriod;
}
