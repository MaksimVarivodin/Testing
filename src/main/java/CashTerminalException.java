import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class CashTerminalException extends Exception{
    private String message;
}
