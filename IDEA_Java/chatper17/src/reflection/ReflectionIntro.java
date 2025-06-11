package reflection;

import java.io.*;
import java.lang.reflect.*;
import java.util.Properties;

public class ReflectionIntro {
    // Read class name and method name from a .properties file, then call the class
    // and the method under the given names.

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Properties setting = new Properties();
        setting.put("classfullpath", "reflection.Cat");
        setting.put("method", "hi");
        try {
            setting.store(new FileOutputStream("src\\setting.properties"), "");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Properties loadSetting = new Properties();
        try {
            loadSetting.load(new FileInputStream("src\\setting.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String classfullpath = loadSetting.getProperty("classfullpath");
        String methodName = loadSetting.getProperty("method");
        System.out.println("classfullpath = " + classfullpath);
        System.out.println("method = " + methodName);
        System.out.println("\n");

        // Reflection
        // 1) Load the class. Get an instance cls of class Class.
        Class<?> cls = Class.forName(classfullpath);
        // 2) Get an instance of cls.
        Object o = cls.newInstance();
        System.out.println("o's runtime class type: " + o.getClass());
        // 3) Get an instance method of class Method with cls.
        Method method1 = cls.getMethod(methodName);
        // 4) Call the method with method1
        method1.invoke(o);

        Field nameField = cls.getField("name");
        System.out.println("o's field \"name\": " + nameField.get(o));
    }
}
