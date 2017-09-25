import java.util.Scanner;

public class App {
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i,j,k;
        System.out.print("이름: ");
        System.out.println("홍길동");
        System.out.print("국어: ");
        i = sc.nextInt();
        System.out.print("영어: ");
        j = sc.nextInt();
        System.out.print("영어: ");
        k = sc.nextInt();
        System.out.print("총점: ");
        System.out.println(i+j+k);
        System.out.print("평균: ");
        System.out.println((double)((i+j+k)/3));


    }
}
