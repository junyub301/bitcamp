package java100.app.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Iterator;

import java100.app.domain.Board;
import java100.app.util.Prompts;

public class BoardController extends GenericController<Board>  {
    
    private String dataFilePath;
    
    public BoardController(String dataFilePath) {
        this.dataFilePath = dataFilePath;
        this.init();
    }
    
    @Override
    public void destroy() {
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.dataFilePath)));) {
            for (Board board : this.list) {
                out.println(board.toCSVString());
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        try (BufferedReader in =  new BufferedReader(new FileReader(this.dataFilePath));) {
            String csv = null;
            while((csv =in.readLine()) != null) {
                try {
                    list.add(new Board(csv));
                } catch (CSVFormatException e) {
                    System.err.println("CSV 데이터 형식 오류!");
                    e.printStackTrace();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
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
        Iterator<Board> iterator = list.iterator();
        while (iterator.hasNext()) {
            Board board = iterator.next();
            out.printf("%d, %s, %s, %d\n",  
                    board.getNo(), 
                    board.getTitle(),
                    board.getRegDate().toString(),
                    board.getViewCount());
        }

    }

    private void doAdd(Request request, Response response) {

        PrintWriter out = response.getWriter();

        Board board = new Board();
        board.setNo(Integer.parseInt(request.getParameter("no")));
        if (findByNo(board.getNo()) != null) {
            out.println("이미 등록된 번호 입니다");
            return;
        }

        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));
        board.setRegDate(new Date(System.currentTimeMillis()));

        list.add(board);
        out.println("저장하였습니다.");
    }

    private void doView(Request request, Response response) {
        PrintWriter out = response.getWriter();
        
        out.println("[회원 정보]");
        int no =Integer.parseInt(request.getParameter("no"));

        Board board = findByNo(no);

        if (board == null) {
            out.printf("%d번 게시물이 없습니다.\n", no);
        } 
        board.setViewCount(board.getViewCount() + 1);
        out.printf("제목: %s\n내용 %s\n등록일: %s\n조회수: %d\n",  
                board.getTitle(), 
                board.getContent(),
                board.getRegDate().toString(),
                board.getViewCount());

    }


    private void doUpdate(Request request, Response response) {
        
        PrintWriter out = response.getWriter();
        
        out.println("[게시물 변경]");
        
        int no = Integer.parseInt(request.getParameter("no"));

        Board board = findByNo(no);

        if (board == null) {
            out.printf("%d번 게시물이 없습니다.\n", no);
            return;
        } 

        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));
        
        out.println("변경했습니다.");

    }    


    private void doDelete(Request request, Response response) {
        PrintWriter out = response.getWriter();
        
        out.println("[성적 삭제]");
        int no =Integer.parseInt(request.getParameter("no"));

        Board board = findByNo(no);

        if (board == null) {
            out.printf("%d번 게시물이 없습니다.\n", no);
            return;
        }
        
            list.remove(board);
            out.println("삭제했습니다.");

    }

    private Board findByNo(int no) {
        Iterator<Board> iterator = list.iterator();
        while (iterator.hasNext()) {
            Board board = iterator.next();
            if(board.getNo() == no) {
                return board;
            }
        }//while
        return null;

    }

}
