package extends01;

public class Graduate extends Student {
    public Graduate(String name, char gender, String school, int ranking) {
        super(name, gender, school, ranking);
    }

    public void testing(String subject){
        System.out.println("Graduate " + name + " is taking the subject " + subject + "...");
    }
}
