package bitcamp.java100;

public class Test17_14 {

    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.printf("swap() : a = %d, b = %d \n", a, b);
    }
    
    static void swap2 (int[] r) {
        int temp = r[0];
        r[0] = r[1];
        r[1] = temp;
        System.out.printf("swap2() : r[0] = %d, r[1] = %d \n", r[0], r[1]);
    }
    public static void main(String[] args){
        // call by value : 호출할 때 넘기는 값을 넘기는 예
        int a = 5, b = 7;
        swap(a,b);
        
        System.out.printf("swap() : a = %d, b = %d \n", a, b);
        
        // call by reference : 호출할 때 메모리 주소를 넘기는 예
        int[] arr = new int[2];
        arr[0] = 5;
        arr[1] = 7;
        
        swap2(arr);
        System.out.printf("swap2() : arr[0] = %d, arr[1] = %d \n", arr[0], arr[1]);

    }

}