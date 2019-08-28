package springboot.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import springboot.exception.ResourceNotFoundException;
import springboot.exception.ResourceNotFoundException2;

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
    @GetMapping("/illegalArgumentException")
    public void throwException() {
        throw new IllegalArgumentException();
    }
    @GetMapping("/resourceNotFoundException")
    public void throwException2() {
        throw new ResourceNotFoundException();
    }
    @GetMapping("/resourceNotFoundException2")
    public void throwException3(){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, the resourse not found!", new ResourceNotFoundException2());
    }
}
