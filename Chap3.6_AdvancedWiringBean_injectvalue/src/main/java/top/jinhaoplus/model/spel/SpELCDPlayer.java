package top.jinhaoplus.model.spel;

import org.springframework.beans.factory.annotation.Value;

public class SpELCDPlayer {

    // 使用注入bean的属性和方法来填充
    @Value("#{cd.artist?.toUpperCase()}")
    private String logo;

    // 使用类的方法来填充
    @Value("#{T(java.lang.Math).random()*100}")
    private Integer playerMinutes;

    private SpELBlankDisc cd;

    public SpELCDPlayer(SpELBlankDisc cd) {
        this.cd = cd;
    }

    public void play() {
        System.out.println("Player logo : " + logo);
        System.out.println(cd.getTitle() + " : " + cd.getArtist() + " playing in " + playerMinutes + "ms");
    }

}
