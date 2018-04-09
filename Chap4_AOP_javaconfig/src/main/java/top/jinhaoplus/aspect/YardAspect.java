package top.jinhaoplus.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class YardAspect {

    // 带参数的切点用于织入到带参数的方法中去，这样做就可以让切面访问和传递被代理方法的参数
    // 参数showname就会是被调用的原方法的参数showname
    @Pointcut("execution(* top.jinhaoplus.concert.Performance.prepare(String)) " +
            "&& args(showname)")
    public void prepare(String showname) {
    }

    @Before("prepare(showname)")
    public void cleanTheYard(String showname) {
        System.out.println("Clean the yard for " + showname);
    }

    @Before("prepare(showname)")
    public void arrangeFacility(String showname) {
        System.out.println("Arrange the facility for " + showname);
    }
}
