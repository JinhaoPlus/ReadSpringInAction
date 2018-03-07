package top.jinhaoplus;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.jinhaoplus.config.CDPlayerConfig;
import top.jinhaoplus.model.player.CDPlayer;


public class PlayerMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
        CDPlayer player = applicationContext.getBean(CDPlayer.class);
        player.play();
    }
}
