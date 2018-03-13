package top.jinhaoplus.model;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AnotherBlankDisc {

    // @Value注解的属性将会在运行时被推迟处理其属性值
    @Value("${disc.title}")
    private String title;
    @Value("${disc.artist}")
    private String artist;

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

}
