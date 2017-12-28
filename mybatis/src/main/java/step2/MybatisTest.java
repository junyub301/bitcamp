package step2;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTest {
    
    public static void main(String[] args) throws Exception {
        
        // Resources 역할
        // => 파라미터로 주어진 파일을 자바 클래스 경로에서 찾는다.
        // => 그리고 그 파일을 읽을 도구를 리턴한다.
        InputStream inputStream = Resources.getResourceAsStream("step2/mybatis-config.xml");
        
        // SqlSessionFactoryBuilder 역할
        // => 설계도에 맞춰 SqlSessionFactory 객체를 만들어준다.
        //
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        
        // SqlSessionFactory 역할
        // => SQL문을 실행할 때 사용할 SqlSession 객체를 만들어 준다.
        SqlSession sqlSession = sqlSessionFactory.openSession();
        
        // SqlSession 역할
        // => SQL Mapper 파일을 뒤져 SQL문을 꺼낸다. 그리고 실행한다.
        
        // SQ을 실행하는 코드를 이 자리에 두면 된다.
        
        // SqlSession을 사용한 후에는 항상 닫아라!
        sqlSession.close();

        System.out.println("종료!");
    }

}
