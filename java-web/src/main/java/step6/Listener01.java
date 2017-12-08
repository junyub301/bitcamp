package step6;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener01 implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext webApplicationContext = sce.getServletContext();
        
        String driver = webApplicationContext.getInitParameter("driver");
        String url = webApplicationContext.getInitParameter("url");
        
        System.out.printf("driver=> %s\n", driver);
        System.out.printf("url=> %s\n", url);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {}

}
