package si.uni_lj.fe.gamehelperapp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Game {
    String name;
    HashMap<String, Ammo> ammo;
    HashMap<String, Armor> armor;
    HashMap<String, Helmet> helmets;
    HashMap<String, Gun> gun;
    Set<String> catergory;

    public Game(String n) {
        this.name = n;
        catergory= new HashSet<>();
        ammo = new HashMap<>();
        gun = new HashMap<>();
        armor= new HashMap<>();
        helmets= new HashMap<>();
    }
}
