package interface_;

import com.sun.deploy.net.proxy.pac.PACFunctions;

public class InterfaceInheritance {
    public static void main(String[] args) {

    }
}

interface ParentIA {
    void a();
}

interface subIA extends ParentIA {
    void b();
}

class TestClass implements subIA {
    @Override
    public void b() {

    }

    @Override
    public void a() {

    }
}