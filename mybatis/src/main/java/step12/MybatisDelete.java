package step12;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisDelete {

    public static void main(String[] args) throws Exception {
        
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("step12/application-context.xml");
        
        
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);
        
        // delete(SQL문을 찾을 때 이름, 데이터가 저장된 객체)
        // => 원시 타입의 값을 넘기면 auto-boxing 된다.
        int count = boardDao.delete(22);
                
        System.out.printf("%d 개가 삭제되었습니다.\n", count);
        
        iocContainer.close();

    }
}
