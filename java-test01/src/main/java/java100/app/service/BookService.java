package java100.app.service;

import java.util.List;
import java.util.Map;

import java100.app.domain.Book;

public interface BookService {
    
    List<Book> list(int pageNo, int pageSize, Map<String,Object> options);
    int add(Book book);
    int getTotalCount();
    Book get(int no);
    int update(Book book);
    int delete(int no);

}
