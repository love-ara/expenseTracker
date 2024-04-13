package africa.semicolon.expenseTracker.data.model;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document("Category")
public enum ExpenseCategory {
    CLOTHING("name"),
    FOOD("name"),
    TRAVEL("name"),
    SELFCARE("name"),
    EMERGENCY("name"),
    OTHER("name");

    private final String name;

    ExpenseCategory(String name) {
        this.name = name;
    }

}
