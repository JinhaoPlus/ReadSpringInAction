package top.jinhaoplus;

import org.aspectj.lang.ProceedingJoinPoint;

public class AudienceAspect {

    public void silenceCellphones(){
        System.out.println("Silence Cellphones");
    }

    public void applause(){
        System.out.println("CLAP CLAP CLAP");
    }

    public void standup(){
        System.out.println("Standup");
    }

    public void demandRefund(){
        System.out.println("Demanding a refund");
    }

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
