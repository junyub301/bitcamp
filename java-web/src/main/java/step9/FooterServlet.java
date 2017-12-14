package step9;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step9/FooterServlet")
public class FooterServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // res.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = res.getWriter();

        out.println("<footer>");
        out.println("<p>페이지 하단 부분</p>");
        out.println("</footer>");
    }

}









