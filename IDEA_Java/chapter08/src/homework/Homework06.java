package homework;

public class Homework06 {
    //Classes Grand, Father, Son are in the same package.
    //Through "this", "super", what fields and/or methods can each class visit?


}

class Grand{
    String name = "AA";
    private int age = 100;
    public void g1(){}
        //"super": Cannot visit anything
        //"this": Visits everything written above
}

class Father extends Grand{
    String id = "001";
    private double score;
    public void f1(){}
        //"super": Visits Grand.name, Grand.g1()
        //"this": Visits everything written above, Grand.name, Grand.g1()
}

class Son extends Father{
    String name = "BB";
    @Override
    public void g1() {}
    private void show(){}
    //"super": Visits Father.id, Father.f1(), Grand.g1(), Grand.name
    //"this": Visits this.name, this.g1(), this.show(), Father.id, Father.f1()
}