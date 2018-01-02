package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.Board;

public interface BoardDao {
    List<Board> findAll(Map<String,Object> params);
    int insert(Board board);
    int update(Board board);
    int delete(int no);
    void upView(int no);
    Board findByNo(int no); 

}
