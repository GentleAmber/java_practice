package extends01;

public class Extends01 {
    public static void main(String[] args) {
        Pupil pupil = new Pupil("Lil X", 'f', "Burmingham Primary School", 79);
        Graduate graduate = new Graduate("Jackie", 'f', "University of Edinburgh", 30);

        pupil.playing("football");
        graduate.testing("maths");
        pupil.showInfo();
        graduate.showInfo();

    }
}
