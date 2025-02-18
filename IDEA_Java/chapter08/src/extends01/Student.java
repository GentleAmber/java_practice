package extends01;

public class Student {
    public String name;
    public char gender;
    public String school;
    private int ranking;

    public Student(String name, char gender, String school, int ranking) {
        setName(name);
        setGender(gender);
        setRanking(ranking);
        setSchool(school);
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public void showInfo(){
        System.out.println("Name: " + name + "\tGender: " + gender + "\tSchool: "+
                school + "\tRanking: " + ranking);
    }
}
