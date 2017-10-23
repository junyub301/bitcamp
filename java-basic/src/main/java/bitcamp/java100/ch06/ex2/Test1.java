package bitcamp.java100.ch06.ex2;

import java.io.Console;

public class Test1 {

    static Console console;
    static Score[] scores = new Score[100000];
    static int cursor = 0;

    static void prepareConsole() {
        console = System.console();
        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1);
        }
    }

    static void inputScore(Score score) {
        score.name = console.readLine("이름? ");
        score.kor = Integer.parseInt(console.readLine("국어 점수? "));
        score.eng = Integer.parseInt(console.readLine("영어 점수? "));
        score.math = Integer.parseInt(console.readLine("수학 점수? "));
        score.sum = score.kor + score.eng + score.math;
        score.aver = score.sum / 3f;

    }

    static void printScore(Score score) {
        System.out.printf("%10s, %3d, %3d, %3d, %3d, %5.2f\n",
                score.name,
                score.kor,
                score.eng,
                score.math,
                score.sum,
                score.aver);
    }

    static void add(Score score) {

        if (cursor == scores.length) {
            System.err.println("최대 저장 개수를 초과했습니다.");
            return;
        }
        scores[cursor++] = score;
    }

    static int size() {
        return cursor;
    }

    static Score get(int index) {
        if (index < 0 || index >= cursor) {
            return null;
        }

        return scores[index];
    }

    static boolean confirm(String message) {

        String response = console.readLine(message).toLowerCase();
        if(response.equals("y") || response.equals("yes")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        prepareConsole();
        while(true) {
            Score score = new Score();


            inputScore(score);

            add(score);

            if (!confirm("계속하시겠습니까? ")) {
                break;
            }
        }

        for (int i = 0; i < size(); i++) {
            printScore(get(i));
        }
    }

}
