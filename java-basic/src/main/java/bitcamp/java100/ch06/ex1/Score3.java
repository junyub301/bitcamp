package bitcamp.java100.ch06.ex1;

public class Score3 {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
    
    Score3(){
        System.out.println("Score3() 호출됨!");
        
        this.name = "홍길동";
        this.kor = 50;
        this.eng = 50;
        this.math = 50;
        this.compute();
    }
    
    void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.aver = this.sum / 3f;
    }
}
