package il.co.main.exception;

import org.apache.http.HttpStatus;

public class BadRequestException extends ApiException {
    private static final long serialVersionUID = -5540416398447252055L;

    public BadRequestException(String msg) {
        super(HttpStatus.SC_BAD_REQUEST, msg);
    }
}