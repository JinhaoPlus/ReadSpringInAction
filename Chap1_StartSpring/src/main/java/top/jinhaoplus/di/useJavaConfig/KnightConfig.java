package top.jinhaoplus.di.useJavaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.jinhaoplus.model.knight.DragonSlayKnight;
import top.jinhaoplus.model.knight.Knight;
import top.jinhaoplus.model.quest.Quest;
import top.jinhaoplus.model.quest.SlayDragonQuest;


@Configuration
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new DragonSlayKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }

}
