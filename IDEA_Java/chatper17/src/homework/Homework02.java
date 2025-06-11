package homework;

// 1. use forName() to get the Class of File
// 2. Print all the constructors of File
// 3. Create an instance of File via reflection and create "E:\mynew.txt" file

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> fileCls = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = fileCls.getDeclaredConstructors();

        System.out.println("Constructors of File: ");
        for (Constructor c : declaredConstructors) {
            System.out.println(c);
        }
        System.out.println("===========================");

        Constructor<?> constructor = fileCls.getConstructor(String.class);
        Object o = constructor.newInstance("e:\\mynew.txt");
        Method createNewFile = fileCls.getMethod("createNewFile");
        createNewFile.invoke(o);
        System.out.println("File is created.");

    }
}
