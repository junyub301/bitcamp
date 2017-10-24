package bitcamp.java100.ch06.ex5;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {

        Scanner keyScan = new Scanner(System.in);
        
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float aver;
        
        System.out.print("이름? ");
        name = keyScan.nextLine();
        
        System.out.print("국어점수? ");
        kor = keyScan.nextInt();

        System.out.print("영어점수? ");
        eng = keyScan.nextInt();
        
        System.out.print("수학점수? ");
        math = keyScan.nextInt();
        
        sum = kor + eng + math;
        aver = sum / 3f;
        
        System.out.printf("%s, %d, %d, %d, %d, %f\n", name, kor, eng, math, sum, aver);
        

    }
}
