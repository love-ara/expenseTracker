package africa.semicolon.expenseTracker.utils;

import africa.semicolon.expenseTracker.data.model.Expense;
import africa.semicolon.expenseTracker.data.model.ExpenseCategory;
import africa.semicolon.expenseTracker.data.model.User;
import africa.semicolon.expenseTracker.dto.request.*;
import africa.semicolon.expenseTracker.dto.response.*;

import java.time.format.DateTimeFormatter;

public class Mapper {

    public static CreateExpenseResponse mapper(CreateExpenseRequest createExpenseRequest) {
        CreateExpenseResponse createExpenseResponse = new CreateExpenseResponse();
        createExpenseResponse.setExpenseId(createExpenseRequest.getExpenseId());
        createExpenseResponse.setDescription(createExpenseRequest.getDescription());
        createExpenseResponse.setExpenseCategory(createExpenseRequest.getExpenseCategory());
        createExpenseResponse.setAmount(createExpenseRequest.getAmount());
        return createExpenseResponse;
    }



    public static User userMap(RegisterRequest registerRequest){
        User user = new User();
        user.setName(registerRequest.getName());
        user.setUsername(registerRequest.getUsername().toLowerCase());
        user.setPassword(registerRequest.getPassword());
        user.setEmail(registerRequest.getEmail());
        user.setNumber(registerRequest.getPhone());
        return user;
    }
    public static RegisterResponse userMapResponse(User user){
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setResponse(user.getId());
        return registerResponse;
    }
    public static Expense expenseMap(CreateExpenseRequest addExpenseRequest, User user) {
        Expense expense = new Expense();
        expense.setDescription(addExpenseRequest.getDescription());
        expense.setExpenseCategory(ExpenseCategory.valueOf(addExpenseRequest.getExpenseCategory()));
        expense.setAmount(addExpenseRequest.getAmount());
        expense.setUser(user);
        //expense.setExpenseCategory(user.getExpenses().getFirst().getExpenseCategory());
        return expense;
    }
    public static CreateExpenseResponse expenseResponse(Expense expense) {
        CreateExpenseResponse createExpenseResponse = new CreateExpenseResponse();
        createExpenseResponse.setExpenseId(expense.getId());
        createExpenseResponse.setDescription(expense.getDescription());
        //createExpenseResponse.setExpenseCategory(expense.getExpenseCategory().name());
        createExpenseResponse.setAmount(expense.getAmount());
        createExpenseResponse.setExpenseTime(DateTimeFormatter.ofPattern("dd-MM-yyyy")
                .format(expense.getExpenseDate()));
        return createExpenseResponse;
    }

    public static LoginResponse loginMap(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setId(loginRequest.getId());
        return loginResponse;
    }


    public static LogoutResponse logoutMap(LogoutRequest logoutRequest){
        LogoutResponse logoutResponse = new LogoutResponse();
        logoutResponse.setId(logoutRequest.getUsername());
        return logoutResponse;
    }

    public static DeleteResponse deleteMap(DeleteRequest deleteRequest){
        DeleteResponse deleteResponse = new DeleteResponse();
        deleteResponse.setId(deleteRequest.getId());
        return deleteResponse;
    }
    public static Expense updateMapper(UpdateRequest updateRequest, Expense expense){
        expense.setDescription(updateRequest.getDescription());
        expense.setExpenseCategory(ExpenseCategory.valueOf(String.valueOf(updateRequest.getExpenseCategory())));
        expense.setAmount(updateRequest.getAmount());
        return expense;
    }
    public static UpdateResponse updateMap(UpdateRequest updateRequest){
        UpdateResponse updateResponse = new UpdateResponse();
        updateResponse.setId(updateRequest.getId());
        return updateResponse;
    }
}
