package si.uni_lj.fe.gamehelperapp;

import java.util.HashMap;

public class Game {
    String name;
    HashMap<String, Ammo> ammo;
    HashMap<String, Armor> armor;
    HashMap<String, Helmet> helmets;

    public Game(String n) {
        this.name = n;
        ammo = new HashMap<>();
        armor= new HashMap<>();
        helmets= new HashMap<>();
    }
}
