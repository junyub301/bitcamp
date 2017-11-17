package bitcamp.java100;

public class Test13_3 {
      
    public static void main(String[] args){
        
        int[] arr1;

        arr1 = new int[3];
        
        // 프로퍼티(property) : 레퍼런스 변수를 통해 사용하는 내부 변수
        System.out.println(arr1.length);

        arr1[0] = 100;
        arr1[1] = 90;
        arr1[2] = 80;

        // 인덱스 범위를 벗어나면 실행 오류
        //  -> java.lang.ArrayIndexOutOfBoundsException 예외 발생
        arr1[3] =200;





    }

}