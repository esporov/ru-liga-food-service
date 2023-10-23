package domain.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ExceptionBody {

    private String message;
    private Map<String, String> errors;

    public ExceptionBody(String message){
        this.message = message;
    }

    public ExceptionBody(String message, Map<String, String> errors) {
        this.message = message;
        this.errors = errors;
    }
}
