package top.jinhaoplus;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.jinhaoplus.model.player.CDPlayer;

public class PlayerMain {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SoundSystemConfig.class);
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("cdplayer-config.xml");
        CDPlayer player = applicationContext.getBean(CDPlayer.class);
        player.play();
    }
}
