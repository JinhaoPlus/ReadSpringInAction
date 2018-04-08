package top.jinhaoplus.model.knight;

import top.jinhaoplus.model.minstrel.Minstrel;
import top.jinhaoplus.model.quest.Quest;

public class BraveKnight implements Knight {

    private Quest quest;

    private Minstrel minstrel;

    public BraveKnight(Quest quest, Minstrel minstrel) {
        this.quest = quest;
        this.minstrel = minstrel;
    }

    public void embarkOnQuest() {
        minstrel.singBeforeQuest();
        quest.embark();
        minstrel.singAfterQuest();
    }

}
