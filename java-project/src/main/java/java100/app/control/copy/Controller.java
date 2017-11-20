package java100.app.control.copy;

import java.io.PrintStream;

public interface Controller {
    
    void execute(Request request, Response response);
    // 새 규칙을 추가
    // 기존에 이 규칙에 따라 만든 클래스들 오류가 발생할 것이다.
    // 그런 경우를 고려해 새로 추가한 규칙에 대해 기본으로 메서드를 구현 상태로 만든다.
    // 그 문법이 "default" 문법
    
    // 객체를 사용하기 전에 준비시키는 메서드 
    default void init() {}
    // 프로그램을 종료하기 전에 객체에게 마무리 작업을 시키는 메서드 
    default void destroy() {}
    
}
