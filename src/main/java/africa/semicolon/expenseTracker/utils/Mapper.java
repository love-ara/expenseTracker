package africa.semicolon.expenseTracker.utils;

import africa.semicolon.expenseTracker.data.model.User;
import africa.semicolon.expenseTracker.dto.request.CreateExpenseRequest;
import africa.semicolon.expenseTracker.dto.request.RegisterRequest;
import africa.semicolon.expenseTracker.dto.response.CreateExpenseResponse;
import africa.semicolon.expenseTracker.dto.response.RegisterResponse;

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
        user.setUsername(registerRequest.getUsername());
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
}
