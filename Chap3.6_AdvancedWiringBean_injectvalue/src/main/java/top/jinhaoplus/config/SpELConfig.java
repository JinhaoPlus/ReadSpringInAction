package top.jinhaoplus.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.jinhaoplus.model.spel.SpELBlankDisc;
import top.jinhaoplus.model.spel.SpELCDPlayer;

@Configuration
public class SpELConfig {

    @Bean
    public SpELBlankDisc cd() {
        return new SpELBlankDisc();
    }

    @Bean
    public SpELCDPlayer player(SpELBlankDisc cd) {
        return new SpELCDPlayer(cd);
    }
}
