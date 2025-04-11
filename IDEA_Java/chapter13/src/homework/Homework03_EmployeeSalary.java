package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Homework03_EmployeeSalary {
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("jack", 650);
        m.put("tom", 1200);
        m.put("smith", 2900);

        //Change jack's salary to 2600
        m.put("jack", 2600);
        //Add 100 for every employee
        for (Object key:
                m.keySet()) {
            int oldSal = (int) m.get(key);
            m.put(key, oldSal + 100);
        }

        //Go through every employee's name in the map
        for (Object key : m.keySet()) {
            System.out.println(key);
        }

        //Go through every salary in the map
        for (Object key:
                m.keySet()) {
            System.out.println(m.get(key));
        }
    }
}
