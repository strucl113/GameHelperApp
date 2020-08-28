package si.uni_lj.fe.gamehelperapp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Game implements Serializable {
    private  static  final long serialVersionUID=1l;
    String name;
    HashMap<String, Ammo> ammo;
    HashMap<String, Armor> armor;
    HashMap<String, Helmet> helmets;
    HashMap<String, Gun> gun;
    Set<String> category;

    public Game(String n) {
        this.name = n;
        category = new HashSet<>();
        ammo = new HashMap<>();
        gun = new HashMap<>();
        armor= new HashMap<>();
        helmets= new HashMap<>();
    }
}
