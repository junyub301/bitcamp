package java100.app.servlet.score;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.dao.ScoreDao;
import java100.app.domain.Score;
import java100.app.listener.ContextLoaderListener;

@WebServlet("/score/view")
@SuppressWarnings("serial")
public class ScoreViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ScoreDao scoreDao = ContextLoaderListener.iocContainer.getBean(ScoreDao.class);
        
        int no = Integer.parseInt(request.getParameter("no"));
        Score score = scoreDao.selectOne(no); 
        
        request.setAttribute("score", score);
        
        response.setContentType("text/html; charset=UTF-8");
        
        RequestDispatcher rd = request.getRequestDispatcher("/score/view.jsp");
        rd.include(request, response);
    }

}
