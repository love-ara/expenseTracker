package africa.semicolon.expenseTracker.service;

import africa.semicolon.expenseTracker.data.model.Expense;
import africa.semicolon.expenseTracker.data.model.User;
import africa.semicolon.expenseTracker.dto.request.DeleteRequest;
import africa.semicolon.expenseTracker.dto.request.ExpenseRequest;
import africa.semicolon.expenseTracker.dto.request.RegisterRequest;
import africa.semicolon.expenseTracker.dto.request.UpdateRequest;
import africa.semicolon.expenseTracker.dto.response.DeleteResponse;
import africa.semicolon.expenseTracker.dto.response.UpdateResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User registerUser(RegisterRequest registerRequest) {
        return null;
    }

    @Override
    public Expense addToExpenseList(ExpenseRequest expenseRequest) {
        return null;
    }

    @Override
    public DeleteResponse deleteFromExpenseList(DeleteRequest deleteRequest) {
        return null;
    }

    @Override
    public UpdateResponse updateExpenseList(UpdateRequest updateRequest) {
        return null;
    }

    @Override
    public Expense getExpense(String id) {
        return null;
    }

    @Override
    public List<Expense> getExpenses() {
        return null;
    }
}
