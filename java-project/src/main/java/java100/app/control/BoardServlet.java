package java100.app.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java100.app.AppInitServlet;
import java100.app.dao.BoardDao;
import java100.app.domain.Board;

@WebServlet(urlPatterns="/board/*")
public class BoardServlet implements Servlet  {

    ServletConfig servletConfig;

    BoardDao boardDao;

    @Override
    public void destroy() {}

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.servletConfig = config;
        boardDao = AppInitServlet.iocContainer.getBean(BoardDao.class);

    }
    
    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }
    
    @Override
    public String getServletInfo() {
        return "게시물관리 서블릿";
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) 
            throws ServletException, IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        httpResponse.setContentType("text/plain;charset=UTF-8");
        
        switch (httpRequest.getPathInfo()) {
        case "/add": this.doAdd(httpRequest, httpResponse); break;
        case "/list": this.doList(httpRequest, httpResponse); break;
        case "/view": this.doView(httpRequest, httpResponse); break;
        case "/delete": this.doDelete(httpRequest, httpResponse); break;
        case "/update": this.doUpdate(httpRequest, httpResponse); break;
        default:
            response.getWriter().println("해당 명령이 없습니다.");
        }
        System.out.println();
    }

    private void doList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("[게시물 목록]");

        try {
            List<Board> list = boardDao.selectList();
            for (Board board : list) {
                out.printf("%4d, %-4s, %4s, %s\n",  
                        board.getNo(),
                        board.getTitle(),
                        board.getRegDate(),
                        board.getViewCount()); 
            }
        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }

    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

    private void doView(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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


    private void doUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        out.println("[게시물 변경]");

        try {
            Board board = new Board();
            board.setTitle(request.getParameter("title"));
            board.setContent(request.getParameter("contents"));
            board.setNo(Integer.parseInt(request.getParameter("no")));


            // executeUpdate()의 리턴값은 변경된 레코드들의 개수이다.
            // 만약 해당 번호와 일치하는 데이터를 찾지 못해 변경할게 없다면 0을 리턴한다.
            if (boardDao.update(board) > 0 ) { 
                out.println("변경하였습니다..");
            } else {
                out.printf("'%s'의 성적 정보가 없습니다.\n", board.getNo());
            }

        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }

    }    


    private void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            int no = Integer.parseInt(request.getParameter("no"));

            if (boardDao.delete(no) > 0) {
                out.println("삭제했습니다.");
            } else {
                out.printf("'%s'의 성적 정보가 없습니다.\n", no);
            }
        } catch (Exception e ) {
            e.printStackTrace();
            out.println(e.getMessage());
        }

    }


}
