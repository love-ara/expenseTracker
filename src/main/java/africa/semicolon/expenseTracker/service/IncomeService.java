package africa.semicolon.expenseTracker.service;

import africa.semicolon.expenseTracker.dto.request.GetIncomeRequest;
import africa.semicolon.expenseTracker.dto.request.LogIncomeRequest;
import africa.semicolon.expenseTracker.dto.response.getIncomeResponse;
import africa.semicolon.expenseTracker.dto.response.logIncomeResponse;
import org.springframework.stereotype.Service;

@Service
public interface IncomeService {
    logIncomeResponse logIncome(LogIncomeRequest incomeRequest);
    getIncomeResponse getIncome(GetIncomeRequest getIncomeRequest);
    //Calculate income
}
