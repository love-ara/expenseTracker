package africa.semicolon.expenseTracker.service;

import africa.semicolon.expenseTracker.data.model.Expense;
import africa.semicolon.expenseTracker.dto.request.*;
import africa.semicolon.expenseTracker.dto.response.*;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface UserService {
    RegisterResponse registerUser(RegisterRequest registerRequest);
    LoginResponse loginUser(LoginRequest loginRequest);
    LogoutResponse logoutUser(LogoutRequest logoutRequest);
    CreateExpenseResponse addNewExpense(CreateExpenseRequest expenseRequest);
    DeleteResponse deleteFromExpenseList(DeleteRequest deleteRequest);
    UpdateResponse updateExpenseList(UpdateRequest updateRequest);
    Expense getExpense(String id);
    List<Expense> getExpenses();


}
