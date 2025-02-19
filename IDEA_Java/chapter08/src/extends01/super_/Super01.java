package extends01.super_;

public class Super01 {
    public static void main(String[] args) {
        B jack = new B("Jack", 11, "Sichuan 1st Primary School");
        jack.getDetails();
        jack.getMyNameInDifferentWays();
    }
}
class A{
    String name;
    int age;

    public A(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void getDetails(){
        System.out.println("Name: " + name + "\tAge: " + age);
    }
}
class B extends A{
    String school;

    public B(String name, int age, String school) {
        super(name, age);
        this.school = school;
    }

    public void getDetails(){
        super.getDetails();//Use super to call parent class A's getDetails method when
        //there's method with identical name in subclass B
        System.out.println("School: " + school);
    }

    public void getMyNameInDifferentWays(){
        System.out.println("My name is: " + this.name +
                " " + super.name + " " + name);
    }
}