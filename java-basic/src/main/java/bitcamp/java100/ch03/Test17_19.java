package bitcamp.java100.ch03;

public class Test17_19 {
      
    static class My {
        int value;
        
         void print() {
            System.out.println(this.value);
        }
    }
    public static void main(String[] args){
        
        My r1 = new My();
        My r2 = new My();
        My r3 = new My();
        
        r1.value = 100;
        r2.value = 200;
        r3.value = 300;
        
        // 인스턴스 메서드는 클래스 이름으로 호출할 수 없다.
        // My.print(); -> 컴파일 오류
        
        r1.print();
        r2.print();
        r3.print();
        
        My m4 = null;
        m4.print(); // Runtime Exception : 실행중에 발생되는 에러

        String s1 = "Hello";
        // s1.print(); -> 컴파일러는 print()앞에 붙은 레퍼런스의 클래스에서 print()를 찾는다.
        
    }
}