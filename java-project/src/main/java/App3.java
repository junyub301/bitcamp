import java.util.Scanner;

//: ## ver 10
//: - 생성자를 이용하여 인스턴스를 초기화시키라.
//: - 인스턴스를 다루는 메서드는 인스턴스 메서드로 전환하라.
//: 
//: 여러 명의 성적을 저장하고 다음과 같이 출력하라!
//:
//: 출력내용:
//: ```
//: 홍길동, 100,  90,  80, 270,  90.0
//: 임꺽정,  80,  80,  80, 240,  80.0
//: 유관순, 100, 100, 100, 300, 100.0
//: ```



//01026344150
//jinyoun.eom@gmail.com
public class App3 {

   
    public static void main(String[] args) {
        Score3[] scores = new Score3[100];
        int cursor = 0;

        while(true) {
            Score3 score = new Score3();
            ScoreView3.input(score);
            scores[cursor++] = score;

            if(!MassageBox3.confirm("계속 하시겠습니까?")) break; 
        }

        for (int i = 0; i < cursor; i++) {
            ScoreView3.print(scores[i]);
        }
    }
}



