package step12;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisUpdate {

    public static void main(String[] args) throws Exception {
        
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("step12/application-context.xml");
        
        
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);
        
        // update를 실행할 때 넘겨줄 Board 객체를 준비한다.
        Board board = new Board();
        board.setNo(20);
        board.setTitle("제목변경!");
        board.setContents("내용 변경!");
        // insert(SQL문을 찾을 때 이름, 데이터가 저장된 객체)
        int count = boardDao.update(board);
                
        
        System.out.printf("%d 개가 변경되었습니다.\n", count);

        iocContainer.close();

    }
}
