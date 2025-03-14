package static_;

public class CodeBlockDetails02 {
    public static void main(String[] args) {
        new BB();
        //See what's printed
        System.out.println("==================");
        BB.getN2();
        /*
        * AA's getN2() (static)
        * AA's static code block
        * BB's getN2() (static)
        * BB's static code block
        * AA's getN2() (static)
        * */
        System.out.println("==================");
        BB.getBBN2();
        System.out.println("==================");
        new BB();


    }
}

class AA {
    private int n1 = getN1();
    private static int n2 = getN2();

    static {
        System.out.println("AA's static code block");
    }
    {
        System.out.println("AA's code block");
    }
    public AA() {
        System.out.println("AA's constructor");
    }
    public int getN1() {
        System.out.println("AA's getN1()");
        return 100;
    }

    public static int getN2() {
        System.out.println("AA's getN2() (static)");
        return 200;
    }
}

class BB extends AA {
    private int n1 = getBBN1();
    private static int n2 = getBBN2();

    static {
        System.out.println("BB's static code block");
    }

    {
        System.out.println("BB's code block");
    }
    public BB() {
        System.out.println("BB's constructor");
    }

    public int getBBN1() {
        System.out.println("BB's getN1()");
        return 100;
    }

    public static int getBBN2() {
        System.out.println("BB's getN2() (static)");
        return 200;
    }
}