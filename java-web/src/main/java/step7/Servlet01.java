package step7;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step7/Servlet01")
public class Servlet01 extends HttpServlet {


    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");

        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Insert title here</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello, world!</h1>");
        out.println("</body>");
        out.println("</html>");
    }

}









