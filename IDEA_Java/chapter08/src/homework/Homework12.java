package homework;

public class Homework12 {
    public static void main(String[] args) {
        HW12Person[] hw12People = new HW12Person[4];
        hw12People[0] = new HW12Student("Fay", 'm', 18, "s4001");
        hw12People[1] = new HW12Student("Jack", 'f', 17, "s4010");
        hw12People[2] = new HW12Teacher("Manny", 'f', 38, 10);
        hw12People[3] = new HW12Teacher("Jane", 'f', 43, 17);

        new HW12Person().bubbleSort(hw12People);//Sort according to age

        for (int i = 0; i < hw12People.length; i++) {
            hw12People[i].basicInfo(hw12People[i]);
            hw12People[i].studyOrTeach(hw12People[i]);
            hw12People[i].play();
        }
    }
}

class HW12Person {
    private String name;
    private char sex;
    private int age;

    public void play() {
        System.out.println("None");
    }

    public void bubbleSort(HW12Person[] perArr) {
        for (int i = perArr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (perArr[j].age < perArr[j + 1].age) {
                    HW12Person tempP = perArr[j];
                    perArr[j] = perArr[j + 1];
                    perArr[j + 1] = tempP;
                }
            }
        }
    }

    public void studyOrTeach(HW12Person p) {
        if (p instanceof HW12Student) {
            ((HW12Student) p).study();
        } else if (p instanceof HW12Teacher) {
            ((HW12Teacher) p).teach();
        } else {
            System.out.println("Wrong type.");
        }
    }

    public void basicInfo(HW12Person p) {
        System.out.println("==================================");
        if (p instanceof HW12Student) {
            System.out.println("Student's information: ");
            System.out.println("Name: " + this.getName());
            System.out.println("Age: " + this.getAge());
            System.out.println("Sex: " + this.getSex());
            System.out.println("Student ID: " + ((HW12Student) p).getStu_id());
        } else if (p instanceof HW12Teacher) {
            System.out.println("Teacher's information: ");
            System.out.println("Name: " + this.getName());
            System.out.println("Age: " + this.getAge());
            System.out.println("Sex: " + this.getSex());
            System.out.println("Work age: " + ((HW12Teacher) p).getWork_age());
        }
    }

    public HW12Person(String name, char sex, int age) {
        setName(name);
        setSex(sex);
        setAge(age);
    }

    public HW12Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class HW12Student extends HW12Person {
    private String stu_id;

    @Override
    public void play() {
        System.out.println(getName() + " likes playing football.");
    }

    public void study() {
        System.out.println("I promise I will study hard.");
    }

    public HW12Student(String name, char sex, int age, String stu_id) {
        super(name, sex, age);
        setStu_id(stu_id);
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }
}

class HW12Teacher extends HW12Person {
    private int work_age;

    @Override
    public void play() {
        System.out.println(getName() + " likes playing chess.");
    }

    public void teach() {
        System.out.println("I promise I will teach well.");
    }
    public HW12Teacher(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        setWork_age(work_age);
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }
}