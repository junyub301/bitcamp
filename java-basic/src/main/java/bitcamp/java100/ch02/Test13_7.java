package bitcamp.java100.ch02;
public class Test13_7 {
      
    public static void main(String[] args){
        int a = 100;
        int b;

        b = a;
        b = 200;

        System.out.printf("a=%d,  b=%d\n",a,b);

        int[] arr1 = {100, 200, 300};
        int[] arr2;

        // 주소를 저장
        arr2 = arr1; //arr1에 들어있는 주소를 arr2에 저장한다.
        
        arr2[1] = 50;
        System.out.printf("%d %d %d\n",arr1[0],arr1[1],arr1[2]);
    }

}