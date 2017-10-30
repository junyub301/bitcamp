package bitcamp.java100.ch08.ex7;

public class A3 extends A {
    // 접근범위 확장하기 -> 가능
//    protected void m2() {}
//    public void m2() {}
    public void m3() {}
    
    // 접근 범위 축소 -> 불가능
//    private void m2() {} -> 컴파일 오류
//    void m3() {} -> 컴파일 오류
//    protected void m4() {} -> 컴파일 오류
//    void m4() {} -> 컴파일 오류
}


// 서브 클래스에서는 확장은 가능하나 줄이는건 불가능
