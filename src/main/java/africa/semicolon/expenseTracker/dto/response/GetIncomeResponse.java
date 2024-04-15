package africa.semicolon.expenseTracker.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GetIncomeResponse {
    public String incomeId;
    public String incomeName;
    public String incomeType;
    public String incomeDate;
    public String incomeCategory;
    public String incomeDescription;
    public BigDecimal incomeAmount;
}
