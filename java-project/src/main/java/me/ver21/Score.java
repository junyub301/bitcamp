package me.ver21;
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

    static boolean confirm2(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        String response = sc.nextLine().toLowerCase();

        if(response.equals("n") || response.equals("N") || response.equals("") ) {
            return false;
        }
        return true;
    }

    public void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("국어점수?(%d) ", subjects[0]);
        int kor = this.subjects[0];
        try {
            kor = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {}

        System.out.printf("영어점수?(%d) ", subjects[1]);
        int eng = this.subjects[1];
        try {
            eng = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {}

        System.out.printf("수학점수?(%d) ",subjects[2]);
        int math = this.subjects[1];
        try {
            math = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {}

        if (confirm2("변경하시겠습니까?(y/N) ")) {
            this.subjects[0] = kor;
            this.subjects[1] = eng;
            this.subjects[2] = math;
            this.compute();
            System.out.println("변경하였습니다.");
        } else {
            System.out.println("변경 취소하였습니다.");
        }

    }

    public void list() {
        System.out.printf("%-4s, %4d, %6.1f\n",  
                this.name, 

                this.sum, 
                this.aver);
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
        int sum = 0;
        for (int sub : this.subjects) {
            sum += sub;
        }
        this.sum = sum;
        this.aver = (float)this.sum / this.subjects.length;
    }







    //: ### 인스턴스 메서드
    //: 인스턴스 데이터를 다루는 메서드는 스태틱 보다 인스턴스 메서드로 선언해야 한다W.


}
