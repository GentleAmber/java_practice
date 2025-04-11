package map;

import java.util.Properties;

public class PropertiesIntro {
    public static void main(String[] args) {
        Properties p = new Properties();
        p.put("k1",1);
        p.put("k2","1");
        System.out.println(p.getProperty("k1"));//Can only get String values.
        System.out.println(p.getProperty("k2"));

    }
}
