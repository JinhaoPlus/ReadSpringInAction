package top.jinhaoplus.model.spel;

import org.springframework.beans.factory.annotation.Value;

public class SpELBlankDisc {
    // #{ ... }是SpEL, ${ ... }是属性占位符
    // systemProperties是系统属性，可以通过设置环境变量的方式来实现
    @Value("#{systemProperties['disc.title']}")
    // #{'Sgt. Peppers Lonely Hearts Club Band'}
    private String title;
    @Value("#{systemProperties['disc.artist']}")
    private String artist;

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}
