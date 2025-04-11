package map;

import java.util.Hashtable;

public class HashTableIntro {
    public static void main(String[] args) {
        Hashtable table = new Hashtable();
//        table.put(null, "01");
//        HashMap map = new HashMap();
//        map.put(null, "01");//Can put key as null because the source code returns 0 for it.
        table.put("k01","juice");
        table.put("k02","apple");
        table.put("k02","pear");

        table.remove("k02");
        table.get("k02");
        System.out.println(table);

    }
}
