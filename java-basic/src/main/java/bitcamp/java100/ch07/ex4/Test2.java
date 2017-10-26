package bitcamp.java100.ch07.ex4;
// Object클래스에서 모든 객체가 반드시 가져야할 최소한의 메서드를 제공한다.
// 주요 인스턴스 메서드

public class Test2 {
    
    public static void main(String[] args) {
        
        Test2 obj = new Test2();
        
        // toString() -> 인스턴스에 대해 간단한 정보를 문자열로 리턴(클래스명@인스턴스를 식별하는hash값 형태로 출력)
        System.out.println(obj.toString());
        System.out.println("--------------------------------------");
        // hashCode() -> hash값만 따로 리턴한다.
        System.out.println(Integer.toHexString(obj.hashCode()));
        System.out.println("--------------------------------------");
        
        // equals() -> 인스턴스가 같은지 비교하여 true/false값을 리턴
        Test2 obj2 = new Test2();
        Test2 obj3 = obj;
        System.out.println(obj.equals(obj2));
        System.out.println(obj.equals(obj3));
        System.out.println("--------------------------------------");
        
        // equals() 메서드를 재정의한 대표적인 클래스
        // => String 와 wrapper 클래스
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println("--------------------------------------");
        
        // StringBuffer는 equals()를 재정의 하지 않았으므로 Object의 equals()를 그대로 사용한다.
        StringBuffer sb1 = new StringBuffer("hello");
        StringBuffer sb2 = new StringBuffer("hello");
        System.out.println(sb1 == sb2);
        System.out.println(sb1.equals(sb2));
        System.out.println("--------------------------------------");

        // getClass() -> 인스턴스의 클래스 정보(를 담은 인스턴스의 주소)를 리턴한다.
        Class c = obj.getClass();
        System.out.println(c.getName());
    }
}
