package models;


public class Response {

    String message;
    boolean success;

    Response(String message,boolean status){

        this.message = message;
        this.success = status;
    }
    Response(){}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
