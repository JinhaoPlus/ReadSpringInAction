package top.jinhaoplus.model.player;

import top.jinhaoplus.model.disc.CompactDisc;

public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }


}
