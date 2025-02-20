package extends01.override;

public class OverrideExercise02 {
    public static void main(String[] args) {
        Person chavvi = new Person("Chavvi", 24);
        Student student = new Student("Jun Zhou", 26, "s3302849", 99.4);

        System.out.println(chavvi.say());
        System.out.println(student.say());

    }
}


class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String say(){
        return "My name is " + name + " and I'm " + age + " years old.";
    }
}

class Student extends Person{
    private String  id;
    private double score;

    public Student(String name, int age, String id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    public String say(){
        return "Hi, I'm a student. " + super.say() + " My studnet ID is " + id +
                ", and my score is " + score + ".";
    }
}
