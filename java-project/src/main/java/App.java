

public class App {
  
    public static void main(String[] args) {
        String[] names = {"이름: ","국어: ","영어: ","수학: ","총점: ","평균: "};
        String name ="홍길동";
        int kor= 97, eng = 85, math = 83, sum =(kor+eng+math);
        float avg = sum/3.0f;

        System.out.printf("이름 : %s\n",name);
        System.out.printf("국어 : %d\n",kor);
        System.out.printf("영어 : %d\n",eng);
        System.out.printf("수학 : %d\n",math);
        System.out.printf("총점 : %d\n",sum);
        System.out.printf("평균 : %.1f\n",avg);

        System.out.println(names[0] + name);
        System.out.println(names[1] + kor);
        System.out.println(names[2] + eng);
        System.out.println(names[3] + math);
        System.out.println(names[4] + sum);
        System.out.println(names[5] + avg);
    }
}
