package task3.exceptions;

public class JsonParsingException extends RuntimeException {

    private String message;

    public JsonParsingException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
