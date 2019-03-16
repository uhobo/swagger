package il.co.main.exception;

public class ApiException extends Exception {
    private static final long serialVersionUID = -5085112752305370687L;
    private int code;

    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}