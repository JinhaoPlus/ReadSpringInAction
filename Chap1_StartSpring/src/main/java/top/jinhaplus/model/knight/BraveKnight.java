package top.jinhaplus.model.knight;

import top.jinhaplus.model.minstrel.Minstrel;
import top.jinhaplus.model.quest.Quest;

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
