package com.example.javafx.CreateObject;

import java.util.List;

public class Player extends Character{
    public String playerName;
    public Wand wand;
    public int pet;
    public int house;
    public int level;


    public List<Spell> knownSpell;
    public List<Potion> knownPotion;

    public Player(int pv,String playerName, Wand wand, int pet, int house,List<Spell> knownSpell,List<Potion> knownPotion,int level) {
        super(pv);
        this.playerName = playerName;
        this.wand = wand;
        this.pet = pet;
        this.house = house;
        this.knownSpell = knownSpell;
        this.knownPotion=knownPotion;
        this.level=level;
    }
}
