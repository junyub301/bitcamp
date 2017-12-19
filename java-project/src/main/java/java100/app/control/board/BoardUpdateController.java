package java100.app.control.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.control.PageController;
import java100.app.dao.BoardDao;
import java100.app.domain.Board;

@Component("/board/update")
public class BoardUpdateController implements PageController {
    
    @Autowired BoardDao boardDao;
    
    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception  {
        
        Board board = new Board();
        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("contents"));
        board.setNo(Integer.parseInt(request.getParameter("no")));
        
        boardDao.update(board);

        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "redirect:list.do";
    }

}
