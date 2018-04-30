package top.jinhaoplus.spittr.data;

import top.jinhaoplus.spittr.model.Spitter;

public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
