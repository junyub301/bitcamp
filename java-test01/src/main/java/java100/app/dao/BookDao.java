package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.Book;

public interface BookDao {

    List<Book> findAll(Map<String,Object> params);
    int insert(Book book);
    int countAll();
    Book findByNo(int no);
    int update(Book book);
    int delete(int no);
}
