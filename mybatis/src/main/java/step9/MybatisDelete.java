package step9;

public class MybatisDelete {

    public static void main(String[] args) throws Exception {
        
        BoardDao boardDao = new BoardDao();
        boardDao.setSqlSessionFactory(SqlSessionFactoryBean.getObject());
        
        // delete(SQL문을 찾을 때 이름, 데이터가 저장된 객체)
        // => 원시 타입의 값을 넘기면 auto-boxing 된다.
        int count = boardDao.delete(18);
                
        System.out.printf("%d 개가 삭제되었습니다.\n", count);


    }
}
