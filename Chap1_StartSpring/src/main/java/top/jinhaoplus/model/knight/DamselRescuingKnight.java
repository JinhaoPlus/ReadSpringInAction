package top.jinhaoplus.model.knight;

import top.jinhaoplus.model.quest.RescueDamselQuest;

/**
 * 少女拯救骑士
 */
public class DamselRescuingKnight implements Knight {

    private RescueDamselQuest quest;

    public DamselRescuingKnight() {
        this.quest = new RescueDamselQuest();
    }

    public void embarkOnQuest() {
        quest.embark();
    }

}
