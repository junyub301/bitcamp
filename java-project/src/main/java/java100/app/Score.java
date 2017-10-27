package java100.app;
import java.util.Scanner;

public class Score {

    protected String name;
    protected int[] subjects; 
    protected int sum;
    protected float aver;

    //: ### 생성자 

    public Score(){
        this.subjects = new int[3];
    }

    public Score(String name, int kor, int eng, int math) {
        this.name = name;
        this.subjects = new int[]{kor, eng, math};

        this.compute();
    }
    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("이름? ");
        this.name = scanner.nextLine();

        System.out.print("국어점수? ");
        this.subjects[0] = scanner.nextInt();

        System.out.print("영어점수? ");
        this.subjects[1]= scanner.nextInt();

        System.out.print("수학점수? ");
        this.subjects[2]= scanner.nextInt();

        this.compute();

    }

    public void print() {
        System.out.printf("%-4s, %4d, %4d, %4d, %4d, %6.1f\n",  
                this.name, 
                this.subjects[0], 
                this.subjects[1], 
                this.subjects[2], 
                this.sum, 
                this.aver);
    }
    
    private void compute() {
        for (int sub : this.subjects) {
            this.sum += sub;
        }
        this.aver = (float)this.sum / this.subjects.length;
    }

    //: ### 인스턴스 메서드
    //: 인스턴스 데이터를 다루는 메서드는 스태틱 보다 인스턴스 메서드로 선언해야 한다W.




}
