package africa.semicolon.expenseTracker.service;

import africa.semicolon.expenseTracker.data.model.Expense;
import africa.semicolon.expenseTracker.data.model.User;
import africa.semicolon.expenseTracker.data.repository.ExpenseRepository;
import africa.semicolon.expenseTracker.data.repository.UserRepository;
import africa.semicolon.expenseTracker.dto.request.CreateExpenseRequest;
import africa.semicolon.expenseTracker.dto.response.CreateExpenseResponse;
import africa.semicolon.expenseTracker.exceptions.UsernameNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import static africa.semicolon.expenseTracker.utils.Mapper.*;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService{
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    @Override
    public CreateExpenseResponse createExpense(CreateExpenseRequest addExpenseRequest) {
        User user = findUserBy(addExpenseRequest.getUsername());
        var expense = expenseMap(addExpenseRequest, user);
        expenseRepository.save(expense);
        return expenseResponse(expense);
     }
    public  User findUserBy(String username) {
        User user = userRepository.findByUsername(username.toLowerCase());
        if(user == null) throw new UsernameNotFoundException(username +" not found");
        return user;
    }


}
