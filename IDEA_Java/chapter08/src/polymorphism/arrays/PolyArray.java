package polymorphism.arrays;

public class PolyArray {
    public static void main(String[] args) {
        Person[] personArr = new Person[5];
        personArr[0] = new Person("Jack", 35);
        personArr[1] = new Student("Chris", 16, 671);
        personArr[2] = new Student("Ana", 17, 590);
        personArr[3] = new Teacher("Keren", 36, 35700);
        personArr[4] = new Teacher("William", 42, 42000);

        for (int i = 0; i < personArr.length; i++) {
            System.out.println(personArr[i].say());
            if (personArr[i] instanceof Student) {
                ((Student) personArr[i]).study();
            }else if (personArr[i] instanceof Teacher) {
                ((Teacher) personArr[i]).teach();
            }
        }

        //How to call unique methods in subclasses?
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    public String say() {
        return "Name: " + name + "\tAge: " + age;
    }
}

class Student extends Person {
    private double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String say() {
        return super.say() + "\tScore: " + score;
    }

    public void study() {
        System.out.println(getName() + " is studying Java.");
    }
}

class Teacher extends Person {
    private double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String say() {
        return super.say() + "\tSalary: " + salary;
    }

    public void teach() {
        System.out.println(getName() + " is teaching Java.");
    }
}