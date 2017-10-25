import java.util.Scanner;

//: ## 생성자와 인스턴스 메서드 도입
//: - init() 메서드 대신 생성자를 이용하여 인스턴스를 초기화시킨다.
//: - print() 메서드는 인스턴스 데이터를 다루기 때문에 스태틱 메서드 대신
//:   인스턴스 메서드로 전환한다. 
public class Score2 {

    String name;
    int[] subjects; 
    int sum;
    float aver;

    //: ### 생성자 
    
    Score2(){
        this.subjects = new int[3];
    }
    
    Score2(String name, int kor, int eng, int math) {
        this.name = name;
        this.subjects = new int[]{kor, eng, math};

        this.compute();
    }
    

    //: ### 인스턴스 메서드
    //: 인스턴스 데이터를 다루는 메서드는 스태틱 보다 인스턴스 메서드로 선언해야 한다.
    void compute() {
        for (int sub : this.subjects) {
            this.sum += sub;
        }
        this.aver = (float)this.sum / this.subjects.length;
    }

    void print() {
        System.out.printf("%-4s, %4d, %4d, %4d, %4d, %6.1f\n",  
                this.name, 
                this.subjects[0], 
                this.subjects[1], 
                this.subjects[2], 
                this.sum, 
                this.aver);
    }

        void input() {
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
}
