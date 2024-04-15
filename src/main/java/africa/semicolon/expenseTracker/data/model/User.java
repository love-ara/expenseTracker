package africa.semicolon.expenseTracker.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("User")
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String number;
    @DBRef
    private List<Expense> expenses = new ArrayList<>();
    @DBRef
    private List<Income> sourceOfIncome = new ArrayList<>();
    private BigDecimal amountLeft = BigDecimal.valueOf(0);
    private boolean isLoggedIn = true;
}
