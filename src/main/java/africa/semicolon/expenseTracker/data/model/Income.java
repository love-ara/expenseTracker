package africa.semicolon.expenseTracker.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Income")
public class Income {
    @Id
    private String incomeId;
    private String incomeName;
    private String incomeDescription;
    private String incomeAmount;
    @DBRef
    private IncomeCategory incomeType;
    private String incomeDate;


}
