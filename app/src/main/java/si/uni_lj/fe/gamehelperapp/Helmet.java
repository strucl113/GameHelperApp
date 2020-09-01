package si.uni_lj.fe.gamehelperapp;

import java.io.Serializable;

public class Helmet implements Serializable {
      String name;
      int Armor;
      String Addons;

      public Helmet(String name, int Armor,String Addons) {
            this.name = name;
            this.Armor=Armor;
            this.Addons=Addons;
      }
      public Helmet(String name) {
            this.name = name;
            this.Armor=Armor;
            this.Addons=Addons;
      }
}
