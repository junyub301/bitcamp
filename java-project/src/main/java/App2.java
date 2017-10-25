import java.util.Scanner;

//: ## ver 08
//: - 클래스를 관리하기 쉽도록 별도의 파일로 분리하다. 
//: - 메서드를 사용하여 반복 코드를 분리한다.
//: 
//: 여러 명의 성적을 저장하고 다음과 같이 출력하라!
//:
//: 출력내용:
//: ```
//: 홍길동, 100,  90,  80, 270,  90.0
//: 임꺽정,  80,  80,  80, 240,  80.0
//: 유관순, 100, 100, 100, 300, 100.0
//: ```

public class App2 {

    //: 합계와 평균을 계산하는 코드를 다음과 같이 별도의 메서드로 분리한다.

    static boolean confirm() {
        Scanner sc = new Scanner(System.in);
        System.out.print("계속 하시겠습니까? ");
        String response = sc.nextLine().toLowerCase();
        if(response.equals("y") || response.equals("yes")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        
        
        Score2[] scores = new Score2[100];
        int cursor = 0;
        
        while(true) {
            Score2 score = new Score2();
            
            if(cursor == scores.length) {
                System.out.println("최대 저장 개수를 초과했음");
                return;
            }
            scores[cursor++] = score;
            
            if(!confirm()) break;
            
            
        }
        
        for (int i  = 0; i < cursor; i++) {
            scores[i].print();
        }

  

    }
}




