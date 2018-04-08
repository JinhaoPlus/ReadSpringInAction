package top.jinhaoplus.di.nodi;

import top.jinhaoplus.model.knight.DamselRescuingKnight;
import top.jinhaoplus.model.knight.Knight;

public class KnightMain {
    public static void main(String[] args) {
        Knight knight = new DamselRescuingKnight();
        knight.embarkOnQuest();
    }
}
