package bitcamp.java100.ch06.ex1;

public class Score10 {
    String name = "이름없음";
    int kor = 10;
    int eng = 10;
    int math;
    int sum;
    float aver;

    {
        this.name = "홍길동";
        this.kor = 20;
    }

    Score10(){
        this.name = "임꺽정";
        compute();
    }

    void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.aver = this.sum / 3f;
    }
}
