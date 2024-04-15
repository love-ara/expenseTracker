package africa.semicolon.expenseTracker.dto.request;

import africa.semicolon.expenseTracker.data.model.ExpenseCategory;
import africa.semicolon.expenseTracker.data.model.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
public class UpdateRequest {
    private String id;
    private String description;
    private Double amount;
    private String expenseCategory;
    private String username;
    private String expenseDate;
}
