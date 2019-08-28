package springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ClassName ResourceNotFoundException
 * @Description TODO
 * @Author TOPFEEL
 * @Date 2019/8/28 10:49
 * @Version 1.0
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException2 extends RuntimeException {
    private String message;
    public ResourceNotFoundException2(){

    }
    public ResourceNotFoundException2(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
