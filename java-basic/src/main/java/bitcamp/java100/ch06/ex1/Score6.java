package bitcamp.java100.ch06.ex1;

public class Score6 {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
    
//    Score6() {
//        System.out.println("기본 생성자 호출됨!");
//    }    
    
    void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.aver = this.sum / 3f;
    }
}
