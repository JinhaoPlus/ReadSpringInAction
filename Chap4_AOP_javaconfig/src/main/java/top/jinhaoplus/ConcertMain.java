package top.jinhaoplus;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.jinhaoplus.concert.Performance;
import top.jinhaoplus.config.ConcertConfig;

public class ConcertMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConcertConfig.class);
        // 只有到应用需要被代理的bean时Spring才会创建代理对象
        // SpringAOP的实质上仍然是动态代理，即基于接口的代理，因此只能完成方法级别的代理，对字段的代理需要使用AspectJ等技术
        Performance concert = applicationContext.getBean(Performance.class);
        concert.perform();
    }
}
