package top.jinhaplus.di.useJavaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.jinhaplus.model.knight.DragonSlayKnight;
import top.jinhaplus.model.knight.Knight;
import top.jinhaplus.model.quest.Quest;
import top.jinhaplus.model.quest.SlayDragonQuest;


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
