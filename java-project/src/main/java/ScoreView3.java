import java.util.Scanner;

public class ScoreView3 {
    
    static void input(Score3 score) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("이름? ");
        score.name = scanner.nextLine();
    
        System.out.print("국어점수? ");
        score.subjects[0] = scanner.nextInt();
        
        System.out.print("영어점수? ");
        score.subjects[1]= scanner.nextInt();
        
        System.out.print("수학점수? ");
        score.subjects[2]= scanner.nextInt();
        
        ScoreDao3.compute(score);
    
    }
    
    static void print(Score3 socre) {
        System.out.printf("%-4s, %4d, %4d, %4d, %4d, %6.1f\n",  
                socre.name, 
                socre.subjects[0], 
                socre.subjects[1], 
                socre.subjects[2], 
                socre.sum, 
                socre.aver);
    }
}
