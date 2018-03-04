package top.jinhaplus.di.useJavaConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.jinhaplus.model.knight.Knight;

public class KnightMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(KnightConfig.class);
        Knight knight = applicationContext.getBean(Knight.class);
        knight.embarkOnQuest();
        applicationContext.close();
    }
}
