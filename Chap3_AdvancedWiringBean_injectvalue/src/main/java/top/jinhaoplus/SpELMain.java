package top.jinhaoplus;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.jinhaoplus.config.SpELConfig;
import top.jinhaoplus.model.spel.SpELCDPlayer;

public class SpELMain {
    public static void main(String[] args) {
        System.setProperty("disc.title", "Sgt. Peppers Lonely Hearts Club Band");
        System.setProperty("disc.artist", "The Beatles");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpELConfig.class);
        SpELCDPlayer player = applicationContext.getBean(SpELCDPlayer.class);
        player.play();
    }
}
