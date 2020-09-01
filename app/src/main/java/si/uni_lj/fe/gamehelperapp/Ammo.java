package si.uni_lj.fe.gamehelperapp;

import java.io.Serializable;
import java.util.ArrayList;

public class Ammo implements Serializable {
    String name;
    ArrayList<AmmoType> types;

    public Ammo(String name) {
        this.name = name;
    }
}
