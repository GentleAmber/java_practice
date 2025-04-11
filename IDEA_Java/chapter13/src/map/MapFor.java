package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapFor {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("01","or");
        map.put("02","and");
        map.put("03","XOR");
        map.put("04","not");
        map.put("04","XAND");

        //Iteration method 1
        System.out.println("======method 1======");
        Set keySet = map.keySet();
        for (Object obj:
             keySet) {
            System.out.println(obj + "-" + map.get(obj));
        }

        System.out.println("======method 2======");
        //Iteration method 2
        Collection values = map.values();
        for (Object val :
                values) {
            System.out.println(val);
        }

        System.out.println("======method 3======");
        //Iteration method 3: EntrySet
        Set entrySet = map.entrySet();
        for (Object entry :
                entrySet) {
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }


    }
}
