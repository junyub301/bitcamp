package java100.app.control;

import java.io.PrintWriter;
import java.util.List;

import java100.app.annotation.Component;
import java100.app.dao.BoardDao;
import java100.app.domain.Board;

@Component("/board")
public class BoardController implements Controller  {
    
    BoardDao boardDao;
    
    public void setBoardDao(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Override
    public void destroy() {}

    @Override
    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBC 드라이버 클래스를 찾을 수 없습니다.");
        }
    }

    @Override
    public void execute(Request request, Response response) {

        switch (request.getMenuPath()) {
        case "/board/add": this.doAdd(request, response); break;
        case "/board/list": this.doList(request, response); break;
        case "/board/view": this.doView(request, response); break;
        case "/board/delete": this.doDelete(request, response); break;
        case "/board/update": this.doUpdate(request, response); break;
        default:
            response.getWriter().println("해당 명령이 없습니다.");
        }
        System.out.println();
    }

    private void doList(Request request, Response response) {

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

    private void doAdd(Request request, Response response) {

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

    private void doView(Request request, Response response) {
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


    private void doUpdate(Request request, Response response) {

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


    private void doDelete(Request request, Response response) {
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
