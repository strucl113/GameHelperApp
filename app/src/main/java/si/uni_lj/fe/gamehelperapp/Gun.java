package si.uni_lj.fe.gamehelperapp;

import java.io.Serializable;

public class Gun implements Serializable {
     String name;
     String Damage;
     String Type;

     public Gun(String name) {
          this.name = name;
     }
}
