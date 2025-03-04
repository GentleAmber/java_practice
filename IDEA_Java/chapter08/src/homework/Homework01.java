package homework;

public class Homework01 {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("Jane", 23, "Artist");
        people[1] = new Person("Ana", 46, "Manager");
        people[2] = new Person("Leo", 34, "Chief");

        Person toolPerson = new Person();
        toolPerson.personBubbleSort(people);

        for (int i = 0; i < people.length; i++) {
            people[i].showInfo();
        }
    }
}

class Person{
    String name;
    int age;
    String job;

    public Person() {
    }

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public void personBubbleSort(Person[] people){
        Person tempPerson;
        for (int i = people.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (people[j].age < people[j + 1].age){
                    tempPerson = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = tempPerson;
                }
            }
        }
    }

    public void showInfo(){
        System.out.println(name + "\t" + age + "\t" + job);
    }
}