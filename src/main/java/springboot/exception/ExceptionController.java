package springboot.exception;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ExceptionController
 * @Description TODO
 * @Author TOPFEEL
 * @Date 2019/8/28 11:00
 * @Version 1.0
 */
@RestController
@RequestMapping("/api")
public class ExceptionController {
    @RequestMapping("/illegalArgumentException")
    public void throwException() {
        throw new IllegalArgumentException();
    }
    @RequestMapping("/resourceNotFoundException")
    public void throwException2() {
        throw new ResourceNotFoundException();
    }
}
