package africa.semicolon.expenseTracker.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("User")
public class User {
    private String id;
    private String name;
    private String email;
    @DBRef
    private ExpenseCategory expenseCategory;
}
