package vn.tuananh.userdemo.exception;

public class NotFoundUser extends  RuntimeException{
    public NotFoundUser(String message) {
        super(message);
    }
}
