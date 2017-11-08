package bitcamp.java100.ch13.ex9;

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

        if (score.name.length() == 0) {
            throw new Exception("EmptyString");
        }
        
        System.out.print("국어? ");
        try {
        score.kor = Integer.parseInt(keyScan.nextLine());
        if (score.kor < 0 || score.kor > 100) 
            throw new Exception("ScoreOutOfBounds");
        } catch (NumberFormatException e) {
            throw new Exception("NumberFormatError");
        }

        System.out.print("영어? ");
        try {
            score.eng = Integer.parseInt(keyScan.nextLine());
            if (score.kor < 0 || score.kor > 100) 
                throw new Exception("ScoreOutOfBounds");
        } catch (NumberFormatException e) {
            throw new Exception("NumberFormatError");
        }

        System.out.print("수학? ");
        try {
            score.math = Integer.parseInt(keyScan.nextLine());
            if (score.kor < 0 || score.kor > 100) 
                throw new Exception("ScoreOutOfBounds.");
        } catch (NumberFormatException e) {
            throw new Exception("NumberFormatError");
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
            } catch(Exception e) {
                String message = e.getMessage();
                if (message.equals("EmptyString")) {
                    System.out.println("입력 문자열이 비어있습니다.");
                }else if (message.equals("ScoreOutOfBounds")) {
                    System.out.println("점수의 범위를 벗어났습니다.");
                }else if (message.equals("NumberFormatError")) {
                    System.out.println("숫자 형식이 아닙니다.");
                }
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
