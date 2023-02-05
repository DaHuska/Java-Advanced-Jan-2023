package com.company.DefiningClasses.PokemonTrainer;

import java.util.List;

public class Trainer {
    private static final int DEFAULT_BADGES_COUNT = 0;
    private String name;
    private List<Pokemon> pokemons;
    private int badges;

    Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.pokemons = pokemons;
        this.badges = DEFAULT_BADGES_COUNT;
    }

    public void setBadges() {
        this.badges++;
    }

    public String getName() {
        return this.name;
    }

    public int getBadges() {
        return this.badges;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }
}
