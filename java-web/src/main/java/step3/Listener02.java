package step3;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener02 implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Listener02.requestInitialized()");
        
    }
    
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Listener02.requestDestroyed()");        
    }
}
