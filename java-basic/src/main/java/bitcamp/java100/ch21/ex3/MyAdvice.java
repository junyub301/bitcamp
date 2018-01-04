package bitcamp.java100.ch21.ex3;

// 특정 위치에 삽입될 코드를 갖고 있는 클래스를 정의한다.

public class MyAdvice {

    
    public void doBefore() {
        System.out.println("MyAdvice.doBefore()");
    }

    public void doAfter() {
        System.out.println("MyAdvice.doAfter()");
    }

    public void AfterReturning() {
        System.out.println("MyAdvice.AfterReturning()");
    }

    public void AfterThrowing() {
        System.out.println("MyAdvice.AfterThrowing()");
    }

    public void doAround() {
        System.out.println("MyAdvice.doAround()");
    }
    
}
