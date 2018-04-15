package top.jinhaoplus;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.jinhaoplus.concert.Encoreable;
import top.jinhaoplus.concert.Performance;
import top.jinhaoplus.config.ConcertConfig;

/**
 * SpringAOP的实质上仍然是动态代理，即基于接口的代理，因此只能完成方法级别的代理，对字段的代理需要使用AspectJ等技术
 * 动态代理是基于接口的，比如Concert实现了接口Performance，AOP织入AudienceAspect到Concert实例中去的动态代理形成的proxy对象在外部看来只是Performance类型的实例
 * 调用这个Proxy对象的方法的时候和实际的Concert实例对象已经不同了，因为它具有切面织入的其他逻辑
 * 这就是SpringAOP基于动态代理为什么只能织入方法的原因，因为访问这个proxy bean的时候只能通过访问接口的方法
 */
public class ConcertMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConcertConfig.class);
        // 只有到应用需要被代理的bean时Spring才会创建代理对象
        Performance concert = applicationContext.getBean(Performance.class);
        concert.prepare("Holmes");
        System.out.println("----------------");
        concert.isOpen();
        System.out.println("----------------");
        concert.perform();
        System.out.println("----------------");
        Encoreable encoreable = (Encoreable) concert;
        encoreable.encorePerform();
    }
}
