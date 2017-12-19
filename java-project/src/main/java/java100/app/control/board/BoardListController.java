package java100.app.control.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.control.PageController;
import java100.app.dao.BoardDao;
import java100.app.domain.Board;

@Component("/board/list")
public class BoardListController implements PageController {
    
    
    @Autowired BoardDao boardDao;
    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception  {
        List<Board> list = boardDao.selectList();
        
        request.setAttribute("list", list);
        
        // 프론트 컨트롤러가 실행할 JSP URL을 등록한다.
        return "/board/list.jsp";
    }

}
