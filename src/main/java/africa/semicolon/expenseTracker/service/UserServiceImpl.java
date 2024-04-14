package africa.semicolon.expenseTracker.service;

import africa.semicolon.expenseTracker.data.model.Expense;
import africa.semicolon.expenseTracker.data.model.User;
import africa.semicolon.expenseTracker.data.repository.UserRepository;
import africa.semicolon.expenseTracker.dto.request.*;
import africa.semicolon.expenseTracker.dto.response.*;
import africa.semicolon.expenseTracker.exceptions.IncorrectPasswordException;
import africa.semicolon.expenseTracker.exceptions.UserAlreadyExistException;
import africa.semicolon.expenseTracker.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static africa.semicolon.expenseTracker.utils.Mapper.*;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;


    @Override
    public RegisterResponse registerUser(RegisterRequest registerRequest) {
        validateUser(registerRequest);

        var user = userMap(registerRequest);
        userRepository.save(user);
        return userMapResponse(user);
    }

    private void validateUser(RegisterRequest registerRequest) {
        boolean user_already_exist = userRepository.existsByUsername(registerRequest.getUsername());
        if (user_already_exist) {
            throw new UserAlreadyExistException("This user already has an account");
        }
    }

    @Override
    public LoginResponse loginUser(LoginRequest loginRequest) {
        var user = getUser(loginRequest.getUsername());
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new IncorrectPasswordException("Incorrect password");
        }
        LoginResponse loginResponse = loginMap(loginRequest);
        user.setLoggedIn(true);
        userRepository.save(user);
        return loginResponse;
    }

    @Override
    public LogoutResponse logoutUser(LogoutRequest logoutRequest) {
        var user = getUser(logoutRequest.getUsername());
        user.setLoggedIn(false);
        userRepository.save(user);
        return logoutMap(logoutRequest);
    }

    private User getUser(String username) {
        var user = userRepository.findByUsername(username.toLowerCase());
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
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
