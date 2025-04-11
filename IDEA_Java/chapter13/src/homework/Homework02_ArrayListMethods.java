package homework;

import java.util.ArrayList;
import java.util.Iterator;

public class Homework02_ArrayListMethods {
    /*
    使用ArrayList完成对对象Car（name, price）的各种操作
    add：添加单个元素
    remove：删除指定元素
    contains：查找某元素是否存在
    size：获取元素个数
    isEmpty：判断是否为空
    clear：清空
    addAll：添加多个元素
    containsAll：查找多个元素是否都存在
    removeAll：删除多个元素
    使用增强for和迭代器来遍历所有的car，需要重写Car的toString方法
     */

    public static void main(String[] args) {
        Car car = new Car("宝马", 400000);
        Car car2 = new Car("宾利", 5000000);

        ArrayList arrlist = new ArrayList();
        arrlist.add(car);
        arrlist.add(car2);
        arrlist.remove(car2);
        System.out.println(arrlist.contains(car));
        System.out.println(arrlist.contains(car2));

        ArrayList arrlist2 = new ArrayList();
        arrlist2.add(car);
        arrlist2.add(car2);

        arrlist.addAll(arrlist2);

        Iterator i = arrlist.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        System.out.println("==============");
        arrlist2.remove(car2);
        arrlist.removeAll(arrlist2);
        System.out.println(arrlist);

    }
}
class Car {
    private String brand;
    private double price;

    public Car(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + ", price=" + price;
    }
}