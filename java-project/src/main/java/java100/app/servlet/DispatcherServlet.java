package java100.app.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.control.PageController;
import java100.app.listener.ContextLoaderListener;

// 프론트 컨트롤러
// - 페이지 컨트롤러의 앞 쪽에서 요청을 먼저 받는다.
// - 페이지 컨트롤러가 사용하기 쉽게 요청 데이터를 가공한다.
// - 페이지 컨트롤러가 작업을 완료하면 그 작업 결과를 출력할 JSP를 실행한다.\
// - 또는 redirect 한다.

@WebServlet("*.do")
@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 클라이언트가 요청한 URL에서 .do를 제외한 서블릿 경로를 추출한다.
        String pageControllerPath = request.getServletPath().replace(".do", "");

        // 스프링 IoC 컨테이너에서 페이지 컨트롤러를 찾는다.
        PageController pageController = (PageController)ContextLoaderListener.iocContainer.getBean(pageControllerPath);

        // 만약 못찾았으면 오류를 출력한다.
        if (pageController == null) {
            throw new ServletException("해당 서블릿을 찾을 수 없습니다.");
        }

        try {
            // 페이지 컨트롤러를 찾았으면 호출한다.
            String viewName = pageController.service(request, response);

            if (viewName.startsWith("redirect:")) {
                response.sendRedirect(viewName.substring(9));

            } else {
                response.setContentType("text/html; charset=UTF-8");
                RequestDispatcher rd = request.getRequestDispatcher(viewName);
                rd.include(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

}
