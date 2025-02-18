package extends01;

public class Pupil extends Student {
    public Pupil(String name, char gender, String school, int ranking) {
        super(name, gender, school, ranking);
    }

    public void playing(String subject){
        System.out.println("Pupil " + name + " is playing " + subject + "...");
    }
}
