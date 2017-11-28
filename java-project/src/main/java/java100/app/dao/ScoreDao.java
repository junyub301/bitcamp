package java100.app.dao;

import java.util.List;

import java100.app.domain.Score;

public interface ScoreDao {
    List<Score> selectList();
    int insert(Score score);
    int update(Score score);
    int delete(int no);
    Score selectOne(int no);

}
