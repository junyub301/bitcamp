package step4;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUpdate {

    public static void main(String[] args) throws Exception {
        
        InputStream inputStream = Resources.getResourceAsStream("step4/mybatis-config.xml");
        
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        // update를 실행할 때 넘겨주는 값을 준비한다.
        Map<String,Object> data = new HashMap<>();
        // 값을 저장할 때 사용한 key는 SQL Mapper 파일에서
        // 그 값을 꺼낼 때 사용할 것이다.
        data.put("no", 14);
        data.put("title", "제목 변경!");
        data.put("contents", "내용 변경!");
        
        // insert(SQL문을 찾을 때 이름, 데이터가 저장된 객체)
        int count = sqlSession.update("JdbcTestMapper.update", data);
                
        sqlSession.commit();
        
        System.out.printf("%d 개가 변경되었습니다.\n", count);

        sqlSession.close();

    }
}
