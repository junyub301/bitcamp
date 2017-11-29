package bitcamp.java100.ch19.ex1;

// 클래스 선언부에 붙일수는 있지만 중복해서 붙일 수는 없다.
@MyAnnotation
public class MyClass {
    
    // 필드 선언부에 붙일 수 있다.
    @MyAnnotation
    public int a;
    
    // 메서드 선언부에 붙일 수 있다.
    @MyAnnotation
    public void m() {

        //일반 문장에는 붙일 수 없다.
        //@MyAnnotation - > 오류!
        System.out.println("Hello!!");
    }
    
    // 파라미터 선언부에도 붙일 수 있다.
    public void m2 (@MyAnnotation int a, @MyAnnotation String b) {
        
        
        // 로컬 선언부에도 붙일 수 있다.
        @MyAnnotation
        int x = 10;
    }
    // 즉 선언부에는 모두 애노테이션을 붙일 수 있다.
}
