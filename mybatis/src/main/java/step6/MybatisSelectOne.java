package step6;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSelectOne {

    public static void main(String[] args) throws Exception {

        InputStream inputStream = Resources.getResourceAsStream("step6/mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // selectOne(SQL문을 찾을 때 이름, 데이터)
        Board board = sqlSession.selectOne("JdbcTestMapper.findByNo",12);

        System.out.printf("번호=%d\n",board.getNo());
        System.out.printf("제목=%s\n",board.getTitle());
        System.out.printf("내용=%s\n",board.getContents());
        System.out.printf("날짜=%s\n",board.getCreatedDate());
        System.out.printf("조회수=%d\n",board.getViewCount());

        sqlSession.close();

    }
}
