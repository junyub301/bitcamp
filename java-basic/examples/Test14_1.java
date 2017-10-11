package bitcamp.java100;

public class Test14_1 {
      
    public static void main(String[] args){

        class Score {

            String name;
            int kor;
            int eng;
            int math;
            int sum;
            float avg;

        }
        
        Score r1 = new Score();
        r1.name = "홍길동";
        r1.kor = 100;
        r1.eng = 98;
        r1.math = 95;
        r1.sum = r1.eng + r1.kor + r1.math;
        r1.avg = r1.sum / 3.0f; 
        
        System.out.printf("%s %d %d %d %d %f\n", r1.name, r1.kor, r1.eng, r1.math, r1.sum, r1.avg);


        
    }

}