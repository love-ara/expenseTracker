package africa.semicolon.expenseTracker.service;

import africa.semicolon.expenseTracker.data.model.User;
import africa.semicolon.expenseTracker.data.repository.UserRepository;
import africa.semicolon.expenseTracker.dto.request.LoginRequest;
import africa.semicolon.expenseTracker.dto.request.LogoutRequest;
import africa.semicolon.expenseTracker.dto.request.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UserServiceImplTest {
    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public void setUserService(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }
    @Test
    public void RegisterUserTest() {
        RegisterRequest  registerRequest = new RegisterRequest();
        registerRequest.setEmail("email@email.com");
        registerRequest.setPassword("password");
        registerRequest.setName("Aramide");
        registerRequest.setUsername("Ara");
        registerRequest.setPhone("0123456789");
        userService.registerUser(registerRequest);

        assertThat(userRepository.count(), is(1L));
        assertThat(userRepository.findByUsername("ara"),is(notNullValue()));
    }

    @Test
    public void userLoginTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("email@email.com");
        registerRequest.setPassword("password");
        registerRequest.setName("Ara");
        registerRequest.setUsername("Ara");
        registerRequest.setPhone("0123456789");
        userService.registerUser(registerRequest);
        assertThat(userRepository.findByUsername("ara"),is(notNullValue()));


        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("Ara");
        loginRequest.setPassword("password");

        userService.loginUser(loginRequest);

        var user = userRepository.findByUsername("ara");
        assertThat(user,is(notNullValue()));
        assertThat(user.isLoggedIn(), is(true));
    }
    @Test
    public void userLogoutTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("email@email.com");
        registerRequest.setPassword("password");
        registerRequest.setName("Ara");
        registerRequest.setUsername("Ara");
        registerRequest.setPhone("0123456789");
        userService.registerUser(registerRequest);
        assertThat(userRepository.findByUsername("ara"),is(notNullValue()));



        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("Ara");
        loginRequest.setPassword("password");
        userService.loginUser(loginRequest);

        LogoutRequest logoutRequest = new LogoutRequest();
        logoutRequest.setUsername("Ara");
        userService.logoutUser(logoutRequest);

        User user = userRepository.findByUsername("ara");
        assertThat(user, is(notNullValue()));
        assertThat(user.isLoggedIn(), is(false));
    }
    @Test
    public void addToExpenseList() {
    }

    @Test
    public void deleteFromExpenseList() {
    }

    @Test
    public void updateExpenseList() {
    }

    @Test
    public void getExpense() {

    }

    @Test
    public void getExpenses() {

    }
}