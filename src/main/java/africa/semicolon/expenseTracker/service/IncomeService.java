package africa.semicolon.expenseTracker.service;

import africa.semicolon.expenseTracker.dto.request.GetIncomeRequest;
import africa.semicolon.expenseTracker.dto.request.CalculateTotalIncomeRequest;
import africa.semicolon.expenseTracker.dto.request.LogIncomeRequest;
import africa.semicolon.expenseTracker.dto.response.GetIncomeResponse;
import africa.semicolon.expenseTracker.dto.response.CalculateTotalIncomeResponse;
import africa.semicolon.expenseTracker.dto.response.LogIncomeResponse;
import org.springframework.stereotype.Service;

@Service
public interface IncomeService {
    LogIncomeResponse logIncome(LogIncomeRequest incomeRequest);
    GetIncomeResponse getIncome(GetIncomeRequest getIncomeRequest);
    CalculateTotalIncomeResponse getTotalIncome(CalculateTotalIncomeRequest getTotalIncomeRequest);
}
