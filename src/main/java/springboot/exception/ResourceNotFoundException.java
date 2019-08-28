package springboot.exception;

/**
 * @ClassName ResourceNotFoundException
 * @Description TODO
 * @Author TOPFEEL
 * @Date 2019/8/28 10:49
 * @Version 1.0
 */
public class ResourceNotFoundException extends RuntimeException {
    private String message;
    public ResourceNotFoundException(){
        super();
    }
    public ResourceNotFoundException(String message) {
        super(message);
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
