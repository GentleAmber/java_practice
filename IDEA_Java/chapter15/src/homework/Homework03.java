package homework;

import java.io.*;
import java.util.Properties;

public class Homework03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Properties properties = new Properties();
//        properties.setProperty("name", "tom");
//        properties.setProperty("age", "5");
//        properties.setProperty("color", "red");
//        properties.store(new FileOutputStream("src\\dog.properties"), null);

        Properties properties2 = new Properties();
        properties2.load(new FileInputStream("src\\dog.properties"));


        Dog dog = new Dog(properties2.getProperty("name"),
                Integer.parseInt(properties2.getProperty("age")), properties2.getProperty("color"));

        System.out.println("Dog1 = " + dog);

        ObjectOutputStream oops = new ObjectOutputStream(new FileOutputStream("src\\dog.dat"));
        oops.writeObject(dog);
        oops.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src\\dog.dat"));
        Object dog2 = ois.readObject();
        System.out.println("Dog2 = " + dog2);

    }
}

class Dog implements Serializable{
    private String name;
    private int age;
    private String color;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
