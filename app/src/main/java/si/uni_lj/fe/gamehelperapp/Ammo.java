package si.uni_lj.fe.gamehelperapp;

import java.io.Serializable;
import java.util.HashMap;

public class Ammo implements Serializable {
    String name;
    HashMap<String, AmmoType> types;

    public Ammo(String name) {
        this.name = name;
    }
}
