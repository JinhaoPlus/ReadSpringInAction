package top.jinhaoplus;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.jinhaoplus.model.BlankDisc;

public class XmlPlaceHolderMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("placeholder-config.xml");
        BlankDisc disc = applicationContext.getBean(BlankDisc.class);
        System.out.println(disc.getTitle() + " : " + disc.getArtist());
    }
}
