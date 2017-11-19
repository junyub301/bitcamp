package bitcamp.java100.ch03;
public class Test17_16 {

    public static void main(String[] args){
        
        Test17_16_A.m1();
        Test17_16_B.m1();
        Test17_16_A.m2();
        Test17_16_B.m2();
        Test17_16_A.m3();
        Test17_16_B.m3();
        Test17_16_B.m4();
        // 다른패키지에 있는 클래스를 사용할 때는 전체 패키지명까지 지정!
        // 메서드 앞에 public을 붙이지 않으면 다른 패키지에서 사용할수 없다.
        bitcamp.java100.ch03.other.Test17_16_C.m1();
        bitcamp.java100.ch03.other.Test17_16_C.m2();
        bitcamp.java100.ch03.other.Test17_16_C.m3();
        bitcamp.java100.ch03.other.Test17_16_C.m4();
        
    }

}