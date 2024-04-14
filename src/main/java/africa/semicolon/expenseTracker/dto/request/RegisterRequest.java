package africa.semicolon.expenseTracker.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String phone;
    private String address;

}
