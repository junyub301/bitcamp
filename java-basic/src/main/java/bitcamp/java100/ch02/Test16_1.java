package bitcamp.java100.ch02;
public class Test16_1 {
      
    public static void main(String[] args){

        // 블록{} : 여러 명령어를 묶는 최소 문법이다. (일반블록, 메서드, 클래스, 인스턴스 블록, 스태틱 블록)
        
        int a = 100;
        
        {
            // 자바에서는 바깥 블록에 선언된 이름으로 변수를 만들 수 없다.
            // int a = 200; -> 컴파일 오류
            System.out.println(a);
            int b = 200;
            System.out.println(b);
            {
                System.out.println(b);
                int c = 300;
                System.out.println(c);
            }
        }
       
        System.out.println(a);
        // System.out.println(b); -> 컴파일 오류
        
    }

}