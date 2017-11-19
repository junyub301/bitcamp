package bitcamp.java100.ch02;
public class Test14_5{
      
    public static void main(String[] args){

        class Score {
            
                        String name;
                        int kor;
                        int eng;
                        int math;
                        int sum;
                        float avg;

                        void compute(){
                             sum = kor + eng + math;
                             avg =  sum / 3.0f;
                        }
            
                    }
                    
                    Score r1 = new Score();
                    r1.name = "홍길동";
                    r1.kor = 100;
                    r1.eng = 100;
                    r1.math = 100;
                   
                    r1.compute();
                    
                    System.out.printf("%s %d %d %d %d %f\n", r1.name, r1.kor, r1.eng, r1.math, r1.sum, r1.avg);

                    Score r2 = r1;

                    r1 = new Score();
                    r1.name = "임꺽정";
                    r1.kor = 90;
                    r1.eng = 90;
                    r1.math = 97;
                   

                    r1.compute();
                    System.out.printf("%s %d %d %d %d %f\n", r1.name, r1.kor, r1.eng, r1.math, r1.sum, r1.avg);
                    
                    System.out.printf("%s %d %d %d %d %f\n", r2.name, r2.kor, r2.eng, r2.math, r2.sum, r2.avg);
            
    }

}