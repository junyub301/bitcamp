package step6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Servlet01 extends HttpServlet {
    

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        ServletConfig config = this.getServletConfig();
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        
        res.setContentType("text/plain;charset=UTF-8");
        
        PrintWriter out = res.getWriter();
        out.printf("driver: %s\n", driver);
        out.printf("url: %s\n", url);
        out.printf("name: %s\n", req.getParameter("name"));
        
    }
    
}









