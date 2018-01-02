package java100.app.dao;

import java.util.List;
import java.util.Map;

import java100.app.domain.Member;

public interface MemberDao {

    List<Member> findAll(Map<String,Object> pramas);
    int insert(Member member);
    int update(Member member);
    int delete(int no);
    Member findByNo(int no);

}
