package africa.semicolon.expenseTracker.service;

import africa.semicolon.expenseTracker.data.model.Expense;
import africa.semicolon.expenseTracker.dto.request.CreateExpenseRequest;
import africa.semicolon.expenseTracker.dto.response.CreateExpenseResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ExpenseServiceImpl implements ExpenseService{
    @Override
    public CreateExpenseResponse createExpense(CreateExpenseRequest addExpenseRequest) {
        Expense expense = new Expense();

        expense.setDescription(addExpenseRequest.getDescription());
        expense.setAmount(addExpenseRequest.getAmount());
        expense.setExpenseCategory(addExpenseRequest.getExpenseCategory());
        expense.setExpenseDate(LocalDate.parse(addExpenseRequest.getExpenseDate()));

        return null;
    }
}
