package top.jinhaplus.model.quest;

import java.io.PrintStream;

/**
 * 恶龙斩杀使命
 */
public class SlayDragonQuest implements Quest {

    private PrintStream stream;

    public SlayDragonQuest(PrintStream stream) {
        this.stream = stream;
    }

    public void embark() {
        stream.println("Embarking on quest to slay the dragon!");
    }

}
