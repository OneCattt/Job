package springboot.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName GlobalExceptionHandle
 * @Description 全局异常处理
 * @Author jiangruliang
 * @Date 2019/8/28 10:51
 * @Version 1.0
 */
@ControllerAdvice(assignableTypes = {})
@ResponseBody
public class GlobalExceptionHandle {
    ErrorResponse illegalArgumentResponse = new ErrorResponse(new IllegalArgumentException("参数错误!"));
    ErrorResponse resourceNotFoundException = new ErrorResponse(new ResourceNotFoundException("参数错误!"));

    @ExceptionHandler(value = Exception.class)// 拦截所有异常, 这里只是为了演示，一般情况下一个方法特定处理一种异常
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e){
        if (e instanceof IllegalArgumentException){
            return ResponseEntity.status(400).body(illegalArgumentResponse);
        }
        if (e instanceof  ResourceNotFoundException){
            return ResponseEntity.status(404).body(resourceNotFoundException);
        }
        return null;
    }
}
