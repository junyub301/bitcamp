package bitcamp.java100;

public class Test10_4 {
      
    public static void main(String[] args){
        // 형식
        //->  %[argument_index$][flags][width][.precision]conversion
        // 번호$ : 값의 인덱스를 가리킨다. 1부터 시작
        // 번호s : 문자열을 출력할 때  차지할 칸 수.
        System.out.printf("%4$2s %3$3s %2$4s %1$5s\n", "a", "b", "c", "d");

    
    }



}