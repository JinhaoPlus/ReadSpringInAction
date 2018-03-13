package top.jinhaoplus;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.jinhaoplus.config.EnvironmentDiscConfig;
import top.jinhaoplus.model.BlankDisc;

public class EnvironmentDiscMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(EnvironmentDiscConfig.class);
        BlankDisc disc = applicationContext.getBean(BlankDisc.class);
        System.out.println(disc.getTitle() + " : " + disc.getArtist());
    }
}
