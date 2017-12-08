package java100.app.servlet.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.dao.BoardDao;
import java100.app.domain.Board;
import java100.app.listener.ContextLoaderListener;

@SuppressWarnings("serial")
@WebServlet("/board/add")
public class BoardAddServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        BoardDao boardDao = ContextLoaderListener.iocContainer.getBean(BoardDao.class);
        response.setContentType("text/palin;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            Board board = new Board();
            board.setTitle(request.getParameter("title"));
            board.setContent(request.getParameter("contents"));

            boardDao.insert(board);
            out.println("저장하였습니다.");


        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }
    }

}
