package top.jinhaoplus;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.jinhaoplus.config.PlaceholderDiscConfig;
import top.jinhaoplus.model.AnotherBlankDisc;

public class AutoconfigPlaceHolderMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PlaceholderDiscConfig.class);
        AnotherBlankDisc disc = applicationContext.getBean(AnotherBlankDisc.class);
        System.out.println(disc.getTitle() + " : " + disc.getArtist());
    }
}
