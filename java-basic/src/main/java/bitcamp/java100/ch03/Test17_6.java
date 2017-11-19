package bitcamp.java100.ch03;
public class Test17_6 {

    static int[] m1() {
        
        // 배열을 초기화시키는 문법은 배열 레퍼런스 변수 선언문과 함께 사용
        int[] values = {100, 90, 80};

        int[] values2;
        //values2 = {100,90,80};
        values2 = new int[] {100, 90, 80};
        
        // return {100, 90, 80} -> 오류
        return new int[] {100, 90, 80};
    }

    public static void main(String[] args){

        int[] arr = m1();
       
        for (int i : arr) {
            System.out.println(i);
            
         
        }
    }

}