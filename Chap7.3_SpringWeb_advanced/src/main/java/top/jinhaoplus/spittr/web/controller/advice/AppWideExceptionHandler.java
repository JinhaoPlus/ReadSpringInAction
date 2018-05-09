package top.jinhaoplus.spittr.web.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import top.jinhaoplus.spittr.web.exception.DuplicateSpittleException;

@ControllerAdvice
public class AppWideExceptionHandler {

    // Spring的异常处理之三：使用控制器增强ControllerAdvice
    // 使用控制器增强实际上进行了AOP织入，因此所有的Controller都会织入这些异常捕获的处理逻辑
    // 与直接在Controller方法中使用ExceptionHandler相比实现了全局的异常捕获
    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleNotFound() {
        return "error/duplicate";
    }

}
