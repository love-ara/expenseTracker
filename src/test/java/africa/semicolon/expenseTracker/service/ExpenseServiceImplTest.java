package africa.semicolon.expenseTracker.service;

import africa.semicolon.expenseTracker.data.model.Expense;
import africa.semicolon.expenseTracker.data.model.ExpenseCategory;
import africa.semicolon.expenseTracker.data.repository.ExpenseRepository;
import africa.semicolon.expenseTracker.data.repository.UserRepository;
import africa.semicolon.expenseTracker.dto.request.CreateExpenseRequest;
import africa.semicolon.expenseTracker.dto.request.DeleteRequest;
import africa.semicolon.expenseTracker.dto.request.RegisterRequest;
import africa.semicolon.expenseTracker.dto.request.UpdateRequest;
import africa.semicolon.expenseTracker.dto.response.RegisterResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class ExpenseServiceImplTest {
    private ExpenseService expenseService;
    private ExpenseRepository expenseRepository;
    private UserRepository userRepository;
    private UserService userService;
    private RegisterRequest registerRequest;
    private RegisterResponse registerResponse;

    @Autowired
    public void setExpenseService(ExpenseService expenseService,  UserRepository userRepository, UserService userService, ExpenseRepository expenseRepository) {
        this.expenseService = expenseService;
        this.userRepository = userRepository;
        this.userService = userService;
        this.expenseRepository = expenseRepository;
    }

    @BeforeEach
    public void setUp() {
        expenseRepository.deleteAll();
        userRepository.deleteAll();


        registerRequest = new RegisterRequest();
        registerRequest.setUsername("Ara");
        registerRequest.setEmail("email");
        registerRequest.setPassword("password");
        registerRequest.setName("name");
        userService.registerUser(registerRequest);

    }

    @Test
    public void createAnExpenseTest(){

        CreateExpenseRequest createExpenseRequest = new CreateExpenseRequest();
        createExpenseRequest.setDescription("Test Description");
        createExpenseRequest.setExpenseCategory(ExpenseCategory.CLOTHING.name());
        createExpenseRequest.setAmount(500.00);
        createExpenseRequest.setUsername("Ara");
        expenseService.createExpense(createExpenseRequest);
        assertThat(expenseRepository.count(), is(1L));
    }

    @Test
    public void expenseCanBeUpdatedTest(){

        CreateExpenseRequest createExpenseRequest = new CreateExpenseRequest();
        createExpenseRequest.setDescription("Test Description");
        createExpenseRequest.setExpenseCategory(ExpenseCategory.CLOTHING.name());
        createExpenseRequest.setAmount(500.00);
        createExpenseRequest.setUsername("Ara");
        expenseService.createExpense(createExpenseRequest);
        assertThat(expenseRepository.count(), is(1L));

        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.setId(expenseRepository.findAll().getFirst().getId());
        updateRequest.setDescription("Test Description");
        updateRequest.setExpenseCategory(ExpenseCategory.OTHER.name());
        updateRequest.setAmount(500.00);
        updateRequest.setUsername("Ara");
        expenseService.updateExpense(updateRequest);
        assertThat(expenseRepository.count(), is(1L));

    }

    @Test
    public void expenseCanBeDeletedTest(){
        CreateExpenseRequest createExpenseRequest = new CreateExpenseRequest();
        createExpenseRequest.setDescription("Test Description");
        createExpenseRequest.setExpenseCategory(ExpenseCategory.CLOTHING.name());
        createExpenseRequest.setAmount(500.00);
        createExpenseRequest.setUsername("Ara");
        expenseService.createExpense(createExpenseRequest);

        assertThat(expenseRepository.count(), is(1L));

        DeleteRequest deleteRequest = new DeleteRequest();
        deleteRequest.setUsername("ara");
        deleteRequest.setId(expenseRepository.findAll().getFirst().getId());
        expenseService.deleteExpense(deleteRequest);

        assertThat(expenseRepository.count(), is(0L));
    }


}