package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.BoardDao;
import java100.app.domain.Board;
import java100.app.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
    
    @Autowired BoardDao boardDao;
    
    @Override
    public List<Board> list(int pageNo, int pageSize, Map<String, Object> options) {
       
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo-1) * pageSize);
        params.put("size", pageSize);
        
        if (options != null) {
            params.putAll(options);
        }
        
        return boardDao.findAll(params);
    }

    @Override
    public Board get(int no) {
        return boardDao.findByNo(no);
    }

    @Override
    public int getTotalCount() {
        return boardDao.countAll();
    }

    @Override
    public int add(Board board) {
        return boardDao.insert(board);
    }

    @Override
    public int update(Board board) {
        // TODO Auto-generated method stub
        return boardDao.update(board);
    }

    @Override
    public int delete(int no) {
        // TODO Auto-generated method stub
        return boardDao.delete(no);
    }

    @Override
    public void viewCount(int no) {
        
        boardDao.upView(no);
    }

}
