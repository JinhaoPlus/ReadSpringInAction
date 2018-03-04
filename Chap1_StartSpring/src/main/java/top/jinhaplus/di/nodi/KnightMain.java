package top.jinhaplus.di.nodi;

import top.jinhaplus.model.knight.DamselRescuingKnight;
import top.jinhaplus.model.knight.Knight;

public class KnightMain {
    public static void main(String[] args) {
        Knight knight = new DamselRescuingKnight();
        knight.embarkOnQuest();
    }
}
