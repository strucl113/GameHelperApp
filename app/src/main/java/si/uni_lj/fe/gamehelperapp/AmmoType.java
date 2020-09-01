package si.uni_lj.fe.gamehelperapp;

import java.io.Serializable;

public class AmmoType implements Serializable {
    String name;
    String fleshDamage;
    int penetrationPower;
    int armorDamage;
    int accuracy;
    int recoil;
    int fragmentationChance;


    public AmmoType(String name) {
        this.name = name;
    }

    public AmmoType(String name,String fleshDamage,int penetrationPower,int armorDamage) {
        this.name = name;
        this.fleshDamage =fleshDamage;
        this.penetrationPower=penetrationPower;
        this.armorDamage=armorDamage;
    }
}

