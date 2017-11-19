package bitcamp.java100.ch01;
import java.util.Date;

public class Test10_4 {
      
    public static void main(String[] args){
        // 형식
        //->  %[argument_index$][flags][width][.precision]conversion
        // 번호$ : 값의 인덱스를 가리킨다. 1부터 시작
        // 번호s : 문자열을 출력할 때  차지할 칸 수.
        System.out.printf("%4$2s %3$3s %2$4s %1$5s\n", "a", "b", "c", "d");

        //conversion 사용법
        /* %s : 문자열
           %d : 10진수(decimal)
           %o : 8진수(octal)
           %x : 16진수(hexadecimal)
           %h : Integer.toHexString(arg.hashCode())의 리턴 값
           %f : 부동소수점(floating point)
           %t : Date/Time
           %b : boolean 
           %m : 줄바꿈.=\n
         */
        System.out.printf("%s, %d, %o, %x, %h, %f, %b, %tY \n","홍길동",100,100,100,100,3.14,true,new Date());

        // [.precision]
        System.out.printf("%f, %.1f, %.2f, %.3f, %.4f, %.5f\n",3.141592,3.141592,3.141592,3.141592,3.141592,3.141592);

        // [argument_index$] : %n$f : n번째 값을 넣어라
        System.out.printf("%1$f, %1$.1f, %1$.2f, %1$.3f, %1$.4f, %1$.5f\n",3.141592);
        
        // [width]
        System.out.printf("%1$4s,%1$10s,%2$5.2f,%2$10.3f\n","홍길동",3.14);

        // [flags]
        /* - : 왼쪽 정렬
           + : 부호 출력
           0 : 빈자리를 0으로 채우기                
        */
        System.out.printf("'%10s', '%-10s'\n","홍길동","임꺽정");
        System.out.printf("%d, %+d\n",100,100);
        System.out.printf("%5d, %05d\n",123,123);

        // 날짜 다루기 :%t[날짜관련 전미사]
        /* H : Hour. 00~23
           I : Hour. 01~12
           M : Minute. 00~59
           S : Second. 00~60
           p : 오전(am), 오후(pm) 출력
           Y : Year. 4자리
           y : Year. 2자리
           m : Month. 01~12
           d : Day. 01~31
           e : Day. 1~31
           A : Week. "Sunday"
           a : Week. "Sun"
           B : Month name. "January"
           b : MOnth name. "Jan"
        */
        System.out.printf("%1$tH, %1$tI, %1$tM, %1$tS %1$tp\n", new Date());
        System.out.printf("%1$tH:%1$tM:%1$tS\n", new Date());
        System.out.printf("%1$tY, %1$ty, %1$tm, %1$td %1$te\n", new Date());
        System.out.printf("%1$tm, %1$tB, %1$tb\n", new Date());
        System.out.printf("%1$tA, %1$ta\n", new Date());
    }



}