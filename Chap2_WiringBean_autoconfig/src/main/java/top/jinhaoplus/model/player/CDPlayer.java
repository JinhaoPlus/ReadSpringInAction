package top.jinhaoplus.model.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.jinhaoplus.model.disc.CompactDisc;

// 还可以采用Java依赖注入规范提供的@Named来做注册
@Component
// 可以命名注入的bean @Component("cDPlayer")
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    // 构造器注入
    // 还可以采用Java依赖注入规范提供的@Inject来做注入

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    // setter注入
    // 也可以在这里使用@Autowired来注入
    // 实际上所有的方法都可以这么使用@Autowired，会在Spring容器里尽可能寻找符合要求的bean作为参数注入
    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }



}
