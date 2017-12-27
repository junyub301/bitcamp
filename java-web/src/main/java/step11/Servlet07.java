package step11;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step11/Servlet07")
public class Servlet07 extends HttpServlet {

    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // 쿠키이름을 한글로 작성할 경우
        // res.addCookie(new Cookie("이름", "hong")); // 오류발생
        
        // 쿠키 값을 한글로 작성할 경우
        // => 보내지지만, UTF-8 형식으로 전달된다.
        //    즉 7비트를 초과하는 값이 전달된다.
        //    문제는 네트워크 장비중에 8비트를 처리하지 못하는 경우
        //    데이터가 손실될 수 있다.
        // => 해결책?
        //    ISO-8859-1로 표현하지 못하는 데이터는 URL 인코딩을 하여 보내라!
        res.addCookie(new Cookie("name", URLEncoder.encode("ABC123홍길동", "UTF-8"))); 

    }

}









