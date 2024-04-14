package africa.semicolon.expenseTracker.service;

import africa.semicolon.expenseTracker.data.model.Expense;
import africa.semicolon.expenseTracker.data.model.User;
import africa.semicolon.expenseTracker.data.repository.UserRepository;
import africa.semicolon.expenseTracker.dto.request.*;
import africa.semicolon.expenseTracker.dto.response.*;
import africa.semicolon.expenseTracker.exceptions.ExpenseNotFoundException;
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
    private ExpenseService expenseService;


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
    public CreateExpenseResponse addNewExpense(CreateExpenseRequest expenseRequest) {
        User user = getUser(expenseRequest.getUsername());
        var expense = expenseService.createExpense(expenseRequest);
        CreateExpenseResponse createExpenseResponse = mapper(expenseRequest);
        user.getExpenses().add(expense);
        userRepository.save(user);
        return createExpenseResponse;
    }

    @Override
    public DeleteResponse deleteFromExpenseList(DeleteRequest deleteRequest) {
        User user = getUser(deleteRequest.getUsername());
        Expense expense = findExpense(deleteRequest.getId(), user.getExpenses());
        user.getExpenses().remove(expense);
        userRepository.save(user);
        return expenseService.deleteExpense(deleteRequest);
    }

    private Expense findExpense(String id, List<Expense> expenses) {
        for (Expense expense : expenses) if (expense.getId().equals(id)) return expense;
        throw new ExpenseNotFoundException("Expense not found");
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
