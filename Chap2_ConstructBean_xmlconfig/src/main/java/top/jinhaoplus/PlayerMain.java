package top.jinhaoplus;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.jinhaoplus.model.player.CDPlayer;

public class PlayerMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("playercontext-constructorarg.xml");
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("playercontext-property.xml");
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("playercontext-c.xml");
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("playercontext-p.xml");
        CDPlayer player = applicationContext.getBean(CDPlayer.class);
        player.play();
    }
}
