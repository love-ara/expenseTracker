package africa.semicolon.expenseTracker.service;

import africa.semicolon.expenseTracker.dto.request.CreateExpenseRequest;
import africa.semicolon.expenseTracker.dto.response.CreateExpenseResponse;
import org.springframework.stereotype.Service;

@Service
public interface ExpenseService {
    CreateExpenseResponse createExpense(CreateExpenseRequest addExpenseRequest);
}
