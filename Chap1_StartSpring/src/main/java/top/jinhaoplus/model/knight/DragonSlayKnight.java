package top.jinhaoplus.model.knight;

import top.jinhaoplus.model.quest.Quest;

/**
 * 恶龙砍杀骑士
 */
public class DragonSlayKnight implements Knight {

    private Quest quest;

    public DragonSlayKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }

}
