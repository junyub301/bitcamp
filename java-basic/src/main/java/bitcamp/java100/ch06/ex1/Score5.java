package bitcamp.java100.ch06.ex1;

public class Score5 {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
    
    Score5(){
        System.out.println("Score5() 호출됨!");
        
        this.name = "홍길동";
        this.kor = 50;
        this.eng = 50;
        this.math = 50;
        this.compute();
    }
    
    Score5(String name){
        System.out.println("Score5(String) 호출됨!");
        this.name = name;
    }
    
    Score5(String name, int kor, int eng, int math){
        System.out.println("Score5(String,int,int,int) 호출됨!");
        
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.compute();
    }
    
    void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.aver = this.sum / 3f;
    }
}
