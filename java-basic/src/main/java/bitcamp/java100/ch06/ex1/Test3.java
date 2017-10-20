package bitcamp.java100.ch06.ex1;

public class Test3 {

    public static void main(String[] args) {
        
        Score2 score;
        score = new Score2();
        score.name = "홍길동";
        score.kor = 100;
        score.eng = 100;
        score.math = 100;

        score.compute();
        
    }
}

// 자바에서 제공하지 못하는 복잡한 문법을 구성하는 메모리 : 클래스