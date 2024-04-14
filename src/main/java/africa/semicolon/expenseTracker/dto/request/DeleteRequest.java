package africa.semicolon.expenseTracker.dto.request;

import lombok.Data;

@Data
public class DeleteRequest {
    private String id;
    private String username;
}
