package bitcamp.java100.ch13.ex4;

import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {

    static class Score {
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float aver;
        
    }
    
    static ArrayList<Score> list = new ArrayList<>();
    static Scanner keyScan = new Scanner(System.in);
    
    static void input() throws Exception {
        Score score = new Score();
        System.out.print("이름? ");
        score.name = keyScan.nextLine();
        
        try {
        System.out.print("국어? ");
        score.kor = Integer.parseInt(keyScan.nextLine());
        
        System.out.print("영어? ");
        score.eng = Integer.parseInt(keyScan.nextLine());
        
        System.out.print("수학? ");
        score.math = Integer.parseInt(keyScan.nextLine());
        } catch (RuntimeException e) {
            throw new Exception("입력이 잘못되었습니다.");
        }
        score.sum = score.kor + score.eng + score.math;
        score.aver = score.sum / 3f;
        
        list.add(score);
    }
    
    static void print() {
        for (Score s : list)
            System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);
    }
    
    public static void main(String[] args) {
        
        while (true) {
            try {
            input();
            } catch (Exception e) {
                System.out.println("입력 중 오류가 발생했습니다.");
            }
            System.out.print("계속 하시겠습니까?(Y/n) ");
            String str = keyScan.nextLine().toLowerCase();
            if (str.equals("") || str.equals("y") || str.equals("yes")) {
                continue;
            }
            break;
        }
        System.out.println("----------------------------------------------");
        
        print();
    }
}
