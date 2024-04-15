package africa.semicolon.expenseTracker.controller;

import africa.semicolon.expenseTracker.dto.request.LoginRequest;
import africa.semicolon.expenseTracker.dto.request.RegisterRequest;
import africa.semicolon.expenseTracker.dto.response.ApiResponse;
import africa.semicolon.expenseTracker.exceptions.UserAlreadyExistException;
import africa.semicolon.expenseTracker.exceptions.UserNotFoundException;
import africa.semicolon.expenseTracker.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.OutputKeys;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        try{
            var user = userService.registerUser(registerRequest);
            return new ResponseEntity<>(new ApiResponse(true, user), OK);
        }catch(UserAlreadyExistException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try{
            var user = userService.loginUser(loginRequest);
            return new ResponseEntity<>(new ApiResponse(true, user), OK);
        }catch(UserNotFoundException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
}
