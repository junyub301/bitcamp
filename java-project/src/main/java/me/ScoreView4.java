package me;
import java.util.Scanner;

public class ScoreView4 extends Score4 {
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
        
        ScoreDao4.compute(this);
    
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
}
