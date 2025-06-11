package constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// Demonstrates three ways to create an instance
public class ReflectCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> personClass = Class.forName("constructor.Person");
        // 1. Create an instance via non-parameter constructor,
        // the constructor should be public
        Object o = personClass.newInstance();
        System.out.println(o);
        System.out.println("=================");

        // 2. Create an instance through public constructor with parameters
        Constructor<?> constructor = personClass.getConstructor(String.class);
        Object jack = constructor.newInstance("Jack");
        System.out.println(jack);
        System.out.println("=================");

        // 3. Create an instance through private constructor
        Constructor<?> declaredConstructor = personClass.getDeclaredConstructor(int.class, String.class);
        declaredConstructor.setAccessible(true);// Force access the constructor
        Object ming = declaredConstructor.newInstance(15, "Ming");
        System.out.println(ming);

    }
}
