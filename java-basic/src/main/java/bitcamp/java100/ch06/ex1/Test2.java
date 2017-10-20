package bitcamp.java100.ch06.ex1;

public class Test2 {

    public static void main(String[] args) {
        
        Score score;
        score = new Score();
        score.name = "홍길동";
        score.kor = 100;
        score.eng = 100;
        score.math = 100;
        score.sum = score.kor + score.eng + score.math;
        score.aver = score.sum / 3f;
        
    }
}
