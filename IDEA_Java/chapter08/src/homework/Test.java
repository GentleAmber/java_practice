package homework;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Test {
    public static void main(String[] args) {
        AAAA obj = new BB();
        BB objB = new  BB();
        AAAA objAA = new AAAA();
        System.out.println(obj instanceof BB);//true
        System.out.println(obj instanceof AAAA);//false - > true
        System.out.println(objAA instanceof AAAA);//true
        System.out.println(objAA instanceof BB);//false
    }


}

class AAAA{
    public AAAA() {
    }
}

class BB extends AAAA{
    public BB() {
    }
}
class CC extends AAAA{}