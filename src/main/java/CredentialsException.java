import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class CredentialsException extends Exception{
    @Setter(AccessLevel.NONE)
    private String message;
}
