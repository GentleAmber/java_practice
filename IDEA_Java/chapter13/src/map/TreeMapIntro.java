package map;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapIntro {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();

        treeMap.put("Jesse", "杰西");
        treeMap.put("Walt", "沃特");
        treeMap.put("Gus", "古斯塔沃");
        treeMap.put("Hank", "汉克");

        TreeMap treeMap1 = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).compareTo((String) o2);
            }
        });

        treeMap1.put("Jesse", "杰西");
        treeMap1.put("Walt", "沃特");
        treeMap1.put("Gus", "古斯塔沃");
        treeMap1.put("Hank", "汉克");

        System.out.println("Default constructor: " + treeMap);
        System.out.println("================");
        System.out.println("Constructor with Comparator: " + treeMap1);
    }
}
