package si.uni_lj.fe.gamehelperapp;

import java.io.Serializable;

public class Gun implements Serializable {
     String name;
     int Damage;
     String Type;

     public Gun(String name) {
          this.name = name;
          this.Damage=Damage;
          this.Type=Type;
     }
     public Gun(String name,int Damage,String Type) {
          this.name = name;
          this.Damage=Damage;
          this.Type=Type;
     }
}
