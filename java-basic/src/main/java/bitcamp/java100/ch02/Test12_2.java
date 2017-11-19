package bitcamp.java100.ch02;
public class Test12_2 {
      
    public static void main(String[] args){

        int i;
        int j;

        i = 100;
        j = i;

        System.out.println(i);
        System.out.println(j);

        // 100=200; -> l-value에는 값이 올수 없다.
        // i = 3.14; -> 선언한 타입이 아니면 저장 안됨
        // x =100; -> 타입을 정하지 않고 사용 불가능

    }

}