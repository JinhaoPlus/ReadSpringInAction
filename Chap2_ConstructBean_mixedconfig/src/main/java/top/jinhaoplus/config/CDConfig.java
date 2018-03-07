package top.jinhaoplus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.jinhaoplus.model.disc.CompactDisc;
import top.jinhaoplus.model.disc.TracksDisc;

import java.util.ArrayList;

@Configuration
public class CDConfig {

    @Bean
    public CompactDisc compactDisc() {
        return new TracksDisc("Sgt. Pepper's Lonely Hearts Club Band", "The Beatles", new ArrayList<String>() {{
            add("Sgt. Pepper's Lonely Hearts Club Band");
            add("With a Little Help from My Friends");
            add("Lucy in the Sky with Diamonds");
            add("Getting Better");
            add("Fixing a Hole");
        }});
    }
}