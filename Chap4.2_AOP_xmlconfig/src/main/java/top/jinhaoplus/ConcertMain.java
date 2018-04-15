package top.jinhaoplus;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.jinhaoplus.concert.Encoreable;
import top.jinhaoplus.concert.Performance;

public class ConcertMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Performance concert = applicationContext.getBean(Performance.class);
        concert.prepare("Holmes");
        System.out.println("--------------------");
        concert.isOpen();
        System.out.println("--------------------");
        concert.perform();
        System.out.println("--------------------");
        Encoreable encoreable = (Encoreable) concert;
        encoreable.encorePerform();
    }
}
