package africa.semicolon.expenseTracker.service;

import africa.semicolon.expenseTracker.data.model.Expense;
import africa.semicolon.expenseTracker.dto.request.CreateExpenseRequest;
import africa.semicolon.expenseTracker.dto.request.DeleteRequest;
import africa.semicolon.expenseTracker.dto.response.DeleteResponse;
import org.springframework.stereotype.Service;

@Service
public interface ExpenseService {
    Expense createExpense(CreateExpenseRequest addExpenseRequest);
    DeleteResponse deleteExpense(DeleteRequest deleteRequest);
}
