package java100.app.control.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.control.PageController;
import java100.app.dao.BoardDao;
import java100.app.domain.Board;

@Component("/board/view")
public class BoardViewController implements PageController {
    
    @Autowired BoardDao boardDao;
    
    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        int no = Integer.parseInt(request.getParameter("no"));
        Board board = boardDao.selectOne(no);
        
        request.setAttribute("board", board);
        
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "/board/view.jsp";
    }

}
