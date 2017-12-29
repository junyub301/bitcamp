package step9;

public class MybatisInsert {

    public static void main(String[] args) throws Exception {
        
        BoardDao boardDao = new BoardDao();
        boardDao.setSqlSessionFactory(SqlSessionFactoryBean.getObject());
        
        // insert를 실행할 때 Board 객체를 넘겨줄 것이다.
        Board board = new Board();
        board.setTitle("112132");
        board.setContents("내용이더래요~~~2");
        
        // insert(SQL문을 찾을 때 이름, 데이터가 저장된 객체)
        int count = boardDao.insert(board);
                
        // Mybatis는 기본으로 수동 commit이다.
        // 즉 개발자가 명시적으로 commit()을 호출해야 한다.
        
        System.out.printf("%d 개가 입력되었습니다.\n", count);
    }
}
