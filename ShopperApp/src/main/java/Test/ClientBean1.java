package Test;

import org.springframework.beans.factory.annotation.Autowired;

public class ClientBean1 {
    @Autowired
    private ServiceBean serviceBean;

    public void printBean() {
        System.out.println("ClientBean1: " + System.identityHashCode(serviceBean));
    }
}
