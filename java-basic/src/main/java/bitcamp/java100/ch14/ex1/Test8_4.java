package bitcamp.java100.ch14.ex1;

import java.util.Scanner;

public class Test8_4 {
     static Scanner keyScan = new Scanner(System.in);

    static int sigma(int n) {
       
        long v0, v1, v2, v3, v4, v5, v6, v7;
        if (n == 0) 
            return 0;
        return n + sigma(n - 1);
            
    }

    public static void main(String[] args) throws Exception {
        
        int sum = sigma(100000);
        System.out.println(sum);
//        System.out.println(sigma(10000));

//        for (int i = 1; i <= 10000; i++) {
//            System.out.printf("v%d, ",i);
//        }
    }
}
