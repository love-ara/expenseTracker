package africa.semicolon.expenseTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ExpenseTracker {
    public static void main(String[] args) {
        SpringApplication.run(ExpenseTracker.class, args);
    }
}
