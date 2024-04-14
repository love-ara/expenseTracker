package africa.semicolon.expenseTracker.dto.request;
import lombok.Data;

@Data
public class LoginRequest {
    private String id;
    private String username;
    private String password;
}
