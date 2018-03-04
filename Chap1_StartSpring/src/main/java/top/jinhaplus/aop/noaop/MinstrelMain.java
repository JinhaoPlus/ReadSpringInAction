package top.jinhaplus.aop.noaop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.jinhaplus.model.knight.Knight;

public class MinstrelMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("fixedminstrel.xml");
        Knight knight = applicationContext.getBean(Knight.class);
        knight.embarkOnQuest();
        applicationContext.close();
    }
}
