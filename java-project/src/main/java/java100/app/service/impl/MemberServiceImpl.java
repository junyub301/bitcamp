package java100.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java100.app.dao.MemberDao;
import java100.app.domain.Member;
import java100.app.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired MemberDao memberDao;
    
    @Override
    public List<Member> list(int pageNo, int pageSize, Map<String, Object> options) {
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("startIndex", (pageNo-1) * pageSize);
        params.put("size", pageSize);
        
        if (options != null) {
            params.putAll(options);
        }
        
        return memberDao.findAll(params);
    }

    @Override
    public Member get(int no) {
        // TODO Auto-generated method stub
        return memberDao.findByNo(no);
    }

    @Override
    public int getTotalCount() {
        return memberDao.countAll();
    }

    @Override
    public int add(Member member) {
        return memberDao.insert(member);
    }

    @Override
    public int update(Member member) {
        return memberDao.update(member);
    }

    @Override
    public int delete(int no) {
        return memberDao.delete(no);
    }

    @Override
    public Member get(String email) {
        
        return memberDao.findByEmail(email);
    }

    @Override
    public Member get(String email, String password) {
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        
        return memberDao.findByEmailAndPassword(params);
    }

}
