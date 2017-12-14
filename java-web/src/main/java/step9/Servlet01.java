package step9;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step9/Servlet01")
public class Servlet01 extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>GET/POST 요청 처리</title>");
        out.println("</head>");
        out.println("<body>");
        
        RequestDispatcher rd = req.getRequestDispatcher("/step9/HeaderServlet");
        rd.include(req, res);
        
        out.println("<h1>Servlet01</h1>");
        out.println("<p>이 출력은 Servlet01에서 만든 것이다.</p>");

        rd = req.getRequestDispatcher("/step9/FooterServlet");
        rd.include(req, res);
        
        out.println("</body>");
        out.println("</html>");
    }

}









