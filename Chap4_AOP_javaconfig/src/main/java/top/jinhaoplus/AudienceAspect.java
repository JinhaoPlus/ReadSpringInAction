package top.jinhaoplus;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 使用@Aspect定义切面：切面是Advice增强的行为定义，阐明了Advice增强生成的动态代理的行为和织入方法的位置，SpringAOP只能做到方法级别的代理织入
 */
@Aspect
public class AudienceAspect {

    // 这里的performance()只是一个空方法，实际上只提供了为Pointcut的附着作用，如果不写这个方法那么下面的Advice需要写全Pointcut
    // 如不写这个需要定义成 @Before("execution(* top.jinhaoplus.concert.Performance.perform(..))")
    // 这样做可以拓展复用这个定义好的Pointcut
    // 使用@Pointcut定义切点：切底是织入Advice增强的「规则」，使用Aspect表达式来选择连接点
    @Pointcut("execution(* top.jinhaoplus.concert.Performance.perform(..))")
    public void performance(){}

    @Before("performance()")
    public void silenceCellphones(){
        System.out.println("Silence Cellphones");
    }

    @After("performance()")
    public void applause(){
        System.out.println("CLAP CLAP CLAP");
    }

    @AfterReturning("performance()")
    public void standup(){
        System.out.println("Standup");
    }

    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("Demanding a refund");
    }

    /**
     * 不同类型的Advice增强位置：织入到方法的不同位置：
     * @Before 前置织入
     * @After 后置织入
     * @AfterThrowing 异常后织入
     * @AfterReturnng 返回后织入
     * @Around 环绕织入
     */
    @Around("execution(* top.jinhaoplus.concert.Performance.perform(..))")
    public void watchPerformace(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("Oh it's ready");
            // joinPoint是连接点，是实际上经过Pointcut选择后的方法被织入切面的位置
            joinPoint.proceed();
            System.out.println("Oh it's wonderful");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
