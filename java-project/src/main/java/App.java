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

public class App {

    static boolean confirm(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        String response = sc.nextLine().toLowerCase();

        if(response.equals("y") || response.equals("yes")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        ScoreDao scores = new ScoreDao();


        while(true) {
            Score score = new Score();
            score.input();
            scores.add(score);

            if(!confirm("계속 하시겠습니까?")) break; 
        }

        for (int i = 0; i < scores.size(); i++) {
            scores.get(i).print();
        }
    }
}




