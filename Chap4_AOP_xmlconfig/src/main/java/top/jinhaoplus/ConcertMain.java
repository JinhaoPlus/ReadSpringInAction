package top.jinhaoplus;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.jinhaoplus.concert.Performance;

public class ConcertMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Performance concert = applicationContext.getBean(Performance.class);
        concert.perform();
    }
}
