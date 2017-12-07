package step5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step5/Servlet01")   
public class Servlet01 extends HttpServlet {
    

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.printf("이름: %s\n", req.getParameter("name"));
        out.printf("나이: %s\n", req.getParameter("age"));
        out.printf("재직: %s\n", req.getParameter("working"));
        
        // 지정한 이름의 파라미터를 입력하지 않으면 null
        // 지정한 이름의 파라미터는 있는데 값이 없으면 빈문자열
    }
    
}









