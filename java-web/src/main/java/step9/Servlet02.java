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
@WebServlet("/step9/Servlet02")
public class Servlet02 extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        
        String op = req.getParameter("op");
        switch (op) {
        case "+":
            RequestDispatcher rd = req.getRequestDispatcher("/step9/PlusServlet");
            rd.forward(req, res);
            break;
        case "-":
            rd = req.getRequestDispatcher("/step9/MinusServlet");
            rd.forward(req, res);
            break;
        default:
            res.setContentType("text/plain;charset=UTF-8");
            PrintWriter out = res.getWriter();
            out.printf("'%s' 연산자는 지원하지 않습니다.\n", op);
        }
    }

}









