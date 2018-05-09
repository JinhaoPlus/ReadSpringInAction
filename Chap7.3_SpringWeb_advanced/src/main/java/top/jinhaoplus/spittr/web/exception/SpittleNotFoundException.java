package top.jinhaoplus.spittr.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 使用@ResponseStatus定义抛出此类异常的时候以什么http响应来提示
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Spittle Not Found")
public class SpittleNotFoundException extends RuntimeException {

}
