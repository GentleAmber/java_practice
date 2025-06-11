package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// This programme shows hot to optimize time spent with reflection with the method "setAccessible()"
public class Reflection01 {

    public static void main(String[] args) {
        traditional();
        try {
            reflection();
            reflectionOptimized();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }



    }

    public static void traditional() {
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            cat.cry();
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("Traditional time spent: " + time);
    }

    public static void reflection() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> cls = Class.forName("reflection.Cat");
        Object cat = cls.newInstance();
        Method cry = cls.getMethod("cry");

        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            cry.invoke(cat);
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("reflection time spent: " + time);
    }

    public static void reflectionOptimized() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> cls = Class.forName("reflection.Cat");
        Object cat = cls.newInstance();
        Method cry = cls.getMethod("cry");
        cry.setAccessible(true);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            cry.invoke(cat);
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("reflectionOptimized time spent: " + time);
    }

}
