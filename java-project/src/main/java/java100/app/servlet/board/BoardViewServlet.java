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
@WebServlet("/board/view")
public class BoardViewServlet extends HttpServlet {


    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        BoardDao boardDao = ContextLoaderListener.iocContainer.getBean(BoardDao.class);
        
        response.setContentType("text/palin;charset=UTF-8");
        
        PrintWriter out = response.getWriter();

        out.println("[회원 정보]");

        try {

            int no = Integer.parseInt(request.getParameter("no"));
            Board board = boardDao.selectOne(no);
            if (board != null) {
                out.printf("번호: %d\n", board.getNo());
                out.printf("제목: %s\n", board.getTitle());
                out.printf("내용: %s\n", board.getContent());
                out.printf("등록일: %s\n", board.getRegDate());
                out.printf("조회수: %s\n", board.getViewCount());
            } else {
                out.printf("'%s'번의 성적 정보가 없습니다.\n", no);
            }

        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }

    }

}
