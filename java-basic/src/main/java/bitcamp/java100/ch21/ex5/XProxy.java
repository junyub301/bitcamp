package bitcamp.java100.ch21.ex5;


// advice를 삽입하기 위해 대상 객체에 프록시 객체를 만든다.
// => 인터페이스가 있다면 인터페이스를 구현하여 만들고
// => 없다면 대상이되는 클래스를 상속받아 서브 클래스로 만든다.

public class XProxy extends X {

    @Override
    public String m1(String name) {
        MyAdvice advice = new MyAdvice();

        advice.doBefore(name);
        
        try {
            String returnValue = super.m1(name);
            advice.doAfterReturning(returnValue);
            return returnValue;
        } catch (Exception e) {
            advice.doAfterThrowing(e);
            throw e;
        } finally {
            advice.doAfter();
        }
        
    }

}
