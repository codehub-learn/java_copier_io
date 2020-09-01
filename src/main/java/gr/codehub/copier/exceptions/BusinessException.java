package gr.codehub.copier.exceptions;

public class BusinessException extends Exception {
    private final String message;
    private int id;

    @Override
    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BusinessException(int id, String message){
        super(message);
        this.id = id;
        this.message = message;
    }
}
