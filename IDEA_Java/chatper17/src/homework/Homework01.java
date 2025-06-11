package homework;

// Operate private field via reflection

import java.lang.reflect.Field;

public class Homework01 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        PrivateTest privateTest = new PrivateTest();

        Class<PrivateTest> privateTestClass = PrivateTest.class;
        Field name = privateTestClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(privateTest, "Jack");
        System.out.println(privateTest.getName());
    }

}

class PrivateTest {
    private String name = "hellokitty";

    public String getName() {
        return name;
    }
}
