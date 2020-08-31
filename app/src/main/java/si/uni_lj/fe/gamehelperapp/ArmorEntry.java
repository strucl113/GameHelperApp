package si.uni_lj.fe.gamehelperapp;

import java.io.Serializable;

public class ArmorEntry implements Serializable {
     String name;
     int armor;
     String material;

     public ArmorEntry(String name, int armor, String material) {
          this.name = name;
          this.armor = armor;
          this.material = material;
     }
}
