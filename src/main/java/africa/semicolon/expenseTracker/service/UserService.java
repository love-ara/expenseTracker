package africa.semicolon.expenseTracker.service;

import africa.semicolon.expenseTracker.data.model.Expense;
import africa.semicolon.expenseTracker.data.model.User;
import africa.semicolon.expenseTracker.dto.request.DeleteRequest;
import africa.semicolon.expenseTracker.dto.request.ExpenseRequest;
import africa.semicolon.expenseTracker.dto.request.RegisterRequest;
import africa.semicolon.expenseTracker.dto.request.UpdateRequest;
import africa.semicolon.expenseTracker.dto.response.DeleteResponse;
import africa.semicolon.expenseTracker.dto.response.UpdateResponse;


import java.util.List;

public interface UserService {
    User registerUser(RegisterRequest registerRequest);
    Expense addToExpenseList(ExpenseRequest expenseRequest);
    DeleteResponse deleteFromExpenseList(DeleteRequest deleteRequest);
    UpdateResponse updateExpenseList(UpdateRequest updateRequest);
    Expense getExpense(String id);
    List<Expense> getExpenses();
}
