package java100.app.dao;

import java.util.List;

import java100.app.domain.Board;

public interface BoardDao {
    List<Board> selectList();
    int insert(Board board);
    int update(Board board);
    int delete(int no);
    Board selectOne(int no); 

}
