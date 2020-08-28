package si.uni_lj.fe.gamehelperapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class DataJsonParser {

    private static final String TAG = DataJsonParser.class.getSimpleName();
    // private ArrayList<HashMap<String, String>> DataList = new ArrayList<>();

    public static HashMap<String, Game> parseToArrayList(String jsonStr) {
        HashMap<String, Game> gamesMap = new HashMap<>();
        HashMap<String, AmmoType> ammoTypesMap = new HashMap<>();
        try {
//            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONArray jsonArr = new JSONArray(jsonStr);


            // looping through All data
            for (int i = 0; i < jsonArr.length(); i++) {
                JSONObject c = jsonArr.getJSONObject(i);

                String game = c.getString("Game");
                Game g = new Game(game);

                // Ammo node is JSON Object
                if (c.has("Helmets")) {
                    JSONArray helmets = c.getJSONArray("Helmets");
                    if (helmets.length() > 0) {
                        g.category.add("Helmets");
                    }

                    for (int j = 0; j < helmets.length(); j++) {
                        JSONObject h = helmets.getJSONObject(j);
                        Helmet helmet = new Helmet(h.getString("name"));
                        helmet.Addons = h.getString("Addons");
                        helmet.Armor = h.getString("Armor");
                        g.helmets.put(h.getString("name"), helmet);
                    }
                }
                //ammo
                JSONArray ammos = c.getJSONArray("Ammo");
                if (ammos.length() > 0) {
                    g.category.add("Ammo");
                }
                for (int j = 0; j < ammos.length(); j++) {
                    JSONObject am = ammos.getJSONObject(j);
                    Ammo ammo = new Ammo(am.getString("Name"));

                    JSONArray ammoTypes = ammos.getJSONObject(j).getJSONArray("types");
                    // AmmoType node is JSON Object
                    for (int k = 0; k < ammoTypes.length(); k++) {
                        JSONObject ammoType = ammoTypes.getJSONObject(k);
                        AmmoType type = new AmmoType(ammoType.getString("Name"));
                        type.accuracy = ammoType.getString("Accuracy");
                        type.fleshDamage = ammoType.getString("FleshDamage");
                        type.penetrationPower = ammoType.getString("PenetrationPower");
                        type.armorDamage = ammoType.getString("ArmorDamage");
                        type.recoil = ammoType.getString("Recoil");
                        type.fragmentationChance = ammoType.getString("FragmentationChance");

                        ammoTypesMap.put(type.name, type);

                    }
                    ammo.types = ammoTypesMap;
                    g.ammo.put(ammo.name, ammo);
                }

                // Helmets node is JSON Object
                if (c.has("Armors")) {
                // Armor node is JSON Object
                JSONArray armors = c.getJSONArray("Armors");
                if (armors.length() > 0) {
                    g.category.add("Armor");
                }
                for (int j = 0; j < armors.length(); j++) {
                    JSONObject arm = armors.getJSONObject(j);
                    Armor armor = new Armor(arm.getString("name"));
                    armor.Armor = arm.getString("Armor");
                    armor.Material = arm.getString("Material");
                    g.armor.put(arm.getString("name"), armor);


                }
            }
                // Gun node is JSON Object
                if (c.has("Gun")) {
                    JSONArray Guns = c.getJSONArray("Gun");
                    if (Guns.length() > 0) {
                        g.category.add("Guns");
                    }
                    for (int j = 0; j < Guns.length(); j++) {
                        JSONObject gn = Guns.getJSONObject(j);
                        Gun gun = new Gun(gn.getString("name"));
                        gun.Type = gn.getString("Type");
                        gun.Damage = gn.getString("Damage");
                        g.gun.put(gn.getString("name"), gun);


                    }
                }
                //


                // adding each child node to HashMap key => value
                gamesMap.put(game, g);
            }
        } catch (final JSONException e) {
            Log.e(TAG, "Json parsing error: " + e.getMessage());
        }
        return gamesMap;
    }
}
