package interface_;

public class InterfaceDetails {
    public static void main(String[] args) {
        System.out.println(TestInterface.n1);//prove n1 is static
        //TestInterface.n1 = 20;//prove n1 is final
    }
}

interface TestInterface {
    int n1 = 10;//public static final
}