package africa.semicolon.expenseTracker.data.model;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;


public enum ExpenseCategory {
    CLOTHING,
    FOOD,
    UTILITY,
    TRANSFER,
    TRAVEL,
    SELFCARE,
    EMERGENCY,
    OTHER;
}
