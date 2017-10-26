package bitcamp.java100.ch07.ex4;

public class Test1 {
//    모든 클래스에는 그 클래스의 정보가 담겨있는 인스턴스 주소를 가지고 있다.
//    static Class class = new Class(); => class가 가리키는 인스턴스에는 클래스 정보가 들어있다. 
    //Test1이라는 클래스의 정보가 담겨있는 인스턴스의 주소를 가지고 있다.
    public static void main(String[] args) {
        
        // 해당 인스턴스가 어떤 클래스의 자손인지 검사하기
        // => instanceof 연산자 사용
        // => 인스턴스 주소 instanceof 클래스 이름
        Test1 obj = new Test1();
        if (obj instanceof Test1)
            System.out.println("obj는 Test1의 인스턴스 이다.");
        
        if (obj instanceof Object)
            System.out.println("obj는 Object의 인스턴스 이다.");
        
        Class c = Test1.class;
        Class sc = c.getSuperclass();
        System.out.println(sc.getName());
        
        Class sc2 = sc.getSuperclass();
        System.out.println(sc2);
    }
}
