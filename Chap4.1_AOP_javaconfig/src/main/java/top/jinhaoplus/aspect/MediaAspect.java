package top.jinhaoplus.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MediaAspect {

    @Pointcut("execution(* top.jinhaoplus.concert.Performance.isOpen())")
    public void isOpen() {
    }

    // returning用于声明被织入方法的执行结果的返回值
    // 这个返回值需在mediaVisit方法中作为参数出现
    @AfterReturning(value = "isOpen()", returning = "open")
    public void mediaVisit(boolean open) {
        if (open) {
            System.out.println("media can visit ");
        } else {
            System.out.println("media can't visit ");
        }
    }
}
