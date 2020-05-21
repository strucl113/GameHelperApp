package si.uni_lj.fe.gamehelperapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactsJsonParser {

    private static final String TAG = ContactsJsonParser.class.getSimpleName();
    private ArrayList<HashMap<String, String>> contactList = new ArrayList<>();

    public ArrayList<HashMap<String, String>> parseToArrayList(String jsonStr){
        try {
            JSONObject jsonObj = new JSONObject(jsonStr);

            // Getting JSON Array node
            JSONArray AmmoAll = jsonObj.getJSONArray("Ammo");

            // looping through All ammo
            for (int i = 0; i < AmmoAll.length(); i++) {
                JSONObject c = AmmoAll.getJSONObject(i);

                String Caliber = c.getString("Caliber");
                String Name = c.getString("Name");
                String Flesh = c.getString("Flesh\ndamage");
                String Penetration = c.getString("Penetration\npower");
                String Armor = c.getString("Armor\ndamage %");
                String Accuracy = c.getString("Accuracy\n%");
                String Recoil = c.getString("Recoil\n%");
                String Fragmentation = c.getString("Fragmentation\nchance*");

/*

                // Phone node is JSON Object
                JSONObject Size = c.getJSONObject("Size");
                String C9x18pm = Size.getString("9x18pm");
                String C762x25tt = Size.getString("762x25tt");
                String C9x19 = Size.getString("9x19");
                String C9x21 = Size.getString("9x21_");
                String C57x28 = Size.getString("57x28");
                String C46x30 = Size.getString("46x30");
                String C9x39 = Size.getString("9x39");
                String C366 = Size.getString("366");
                String C545x39 = Size.getString("545x39");
                String C556x45 = Size.getString("556x45");
                String C762x39 = Size.getString("762x39");
                String C762x51 = Size.getString("762x51");
                String C762_54R = Size.getString("762_54R");
                String C127x55 = Size.getString("127x55");
*/


                // tmp hash map for single Ammo
                HashMap<String, String> Ammo = new HashMap<>();

                // adding each child node to HashMap key => value
                Ammo.put("Caliber", Caliber);
                Ammo.put("Name", Name);
                Ammo.put("Flesh", Flesh);
                Ammo.put("Penetration", Penetration);
                Ammo.put("Armor", Armor);
                Ammo.put("Accuracy", Accuracy);
                Ammo.put("Recoil", Recoil);
                Ammo.put("Fragmentation", Fragmentation);


                // adding contact to contact list
                contactList.add(Ammo);
            }
        } catch (final JSONException e) {
            Log.e(TAG, "Json parsing error: " + e.getMessage());
        }
        return contactList;
    }
}
