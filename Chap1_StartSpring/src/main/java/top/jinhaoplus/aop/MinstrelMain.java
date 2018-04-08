package top.jinhaoplus.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.jinhaoplus.model.knight.Knight;

public class MinstrelMain {

    /**
     * 织入bean的切面和bean实际完成的业务逻辑是分离的，业务bean专注于实现业务，织入切面专注于完成通用任务
     * 运行时被织入切面的bean感知不到切面的存在，因为是运行时织入的
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("minstrel.xml");
        Knight knight = applicationContext.getBean(Knight.class);
        knight.embarkOnQuest();
        applicationContext.close();
    }
}
