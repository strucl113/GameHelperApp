package si.uni_lj.fe.gamehelperapp;

import java.io.Serializable;

public class AmmoType implements Serializable {
    String name;
    String fleshDamage;
    String penetrationPower;
    String armorDamage;
    String accuracy;
    String recoil;
    String fragmentationChance;
    public AmmoType(String name) {
        this.name = name;
    }
}

