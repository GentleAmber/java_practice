package collection.generics.homework;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homework01_JUnit {
    public static void main(String[] args) {
        /*
        定义个泛型类 DAO<T>，在其中定义一个 Map 成员变量，Map 的键为 String 类型，值为 T 类型。

        分别创建以下方法：
        (1) public void save(String id, T entity)：保存 T 类型的对象到 Map 成员变量中
        (2) public T get(String id)：从 map 中获取 id 对应的对象
        (3) public void update(String id, T entity)：替换 map 中 key 为 id 的内容，改为 entity 对象
        (4) public List<T> list()：返回 map 中存放的所有 T 对象
        (5) public void delete(String id)：删除指定 id 对象

        定义一个 User 类：
        类包含：private 成员变量（int 类型）id，age；（String 类型）name。

        创建 DAO 类的对象，分别调用 save、get、update、list、delete 方法来操作 User 对象，
        使用 Junit 单元测试类进行测试
         */
    }
    User jack = new User(1231, 32, "Jack");
    User mary = new User(1222, 28, "Mary");
    User john = new User(1322, 22, "John");
    User johnie = new User(1342, 6, "Johnie");

    @Test
    public void testSaveUpdateAndGet() {
        DAO<User> dao = new DAO<>();
        dao.save("1231", jack);
        dao.save("1222", mary);
        dao.save("1322", john);
        dao.save("1342", john);

        System.out.println(dao.get("1342"));

        dao.update("1342", johnie);
        System.out.println(dao.get("1342"));

    }

}

class DAO<T> {
    HashMap<String, T> map = new HashMap<>();

//    @Test //Not here
    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        return (List<T>) map.values();
    }

    public void delete(String id) {
        map.remove(id);
        System.out.println("Id" + id + " removed!");
    }


}
class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}