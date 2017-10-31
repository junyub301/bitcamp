package bitcamp.java100.ch10.ex1;

public class Test2 {

    // static nested class  
    static class A{}

    // non-static nested class = inner class 인스턴스가 있어야만 사용할수 있는 nested class
    class B{}

    // 익명 클래스 : 클래스의 이름이 없어 클래스를 정의하는 동시에 인스턴스를 바로 생성하는 클래스
    Object obj = new Object() {
        String name;
        public void m1() {}
    };
    
    public static void main(String[] args) {

        // 로컬 클래스 : 특정 메서드 에서만 사용하도록 메서드 안에 정의된 클래스
        class c{}

        // 익명 클래스는 메서드 안에서도 정의 가능
        Object obj2 = new Object() {
            String name;
            public void m1() {}
        };
        
        
    }
}
