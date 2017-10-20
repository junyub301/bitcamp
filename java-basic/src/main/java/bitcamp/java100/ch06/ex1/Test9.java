package bitcamp.java100.ch06.ex1;

public class Test9 {

    public static void main(String[] args) {
        
        Score8 score;
        score = new Score8("홍길동");
        
        System.out.printf("이름 = %s\n",score.name);
        System.out.printf("총점 = %d\n",score.sum);
        System.out.printf("평균 = %f\n",score.aver);
        
    }
}

