package Test;

import org.springframework.beans.factory.annotation.Autowired;

public class ClientBean2 {

    @Autowired
    private ServiceBean serviceBean;

    public void printBean() {
        System.out.println("ClientBean2: " + System.identityHashCode(serviceBean));
    }
}
