package bitcamp.java100.ch08.ex1;

class Score2 {
    String name; 
    int kor;
    int eng;
    int math;
    private int sum;
    private float aver;
    
    public void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.aver = this.sum / 3f;
    }
    
    public int getSum() {
        return this.sum;
    }
    
    public float getAver() {
        return this.aver;
    }
    
    
}

public class Test8_2 {
    public static void main(String[] args) {

        Score2 s = new Score2();
        s.name = "홍길동";
        s.kor = 100;
        s.eng = 90;
        s.math = 80;
        
        s.compute();
        
        System.out.printf("%s, %d, %d, %d, %d, %.2f\n", s.name, s.kor, s.eng, s.math, s.getSum(), s.getAver());
        
        s.eng = 50;
        s.compute();
        System.out.printf("%s, %d, %d, %d, %d, %.2f\n", s.name, s.kor, s.eng, s.math, s.getSum(), s.getAver());
    }

}
