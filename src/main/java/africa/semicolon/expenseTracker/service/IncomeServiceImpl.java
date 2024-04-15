package africa.semicolon.expenseTracker.service;

import africa.semicolon.expenseTracker.data.repository.IncomeRepository;
import africa.semicolon.expenseTracker.dto.request.CalculateTotalIncomeRequest;
import africa.semicolon.expenseTracker.dto.request.GetIncomeRequest;
import africa.semicolon.expenseTracker.dto.request.LogIncomeRequest;
import africa.semicolon.expenseTracker.dto.response.CalculateTotalIncomeResponse;
import africa.semicolon.expenseTracker.dto.response.GetIncomeResponse;
import africa.semicolon.expenseTracker.dto.response.LogIncomeResponse;
import africa.semicolon.expenseTracker.exceptions.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IncomeServiceImpl implements IncomeService{
    private IncomeRepository incomeRepository;

    @Override
    public LogIncomeResponse logIncome(LogIncomeRequest incomeRequest) {
        var income = incomeRepository.findById(incomeRequest.getId());
        if (income == null) {
            throw new IncomeNotFoundException("This income is not available");
        }
        return null;
    }

    @Override
    public GetIncomeResponse getIncome(GetIncomeRequest getIncomeRequest) {
        return null;
    }

    @Override
    public CalculateTotalIncomeResponse getTotalIncome(CalculateTotalIncomeRequest getTotalIncomeRequest) {
        return null;
    }
}
