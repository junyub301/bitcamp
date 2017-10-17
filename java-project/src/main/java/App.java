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
 
public class App {
    
    //: 합계와 평균을 계산하는 코드를 다음과 같이 별도의 메서드로 분리한다.
    

    public static void main(String[] args) {
        
        Score[] scores = {new Score(), new Score(), new Score()};
        
        Score.init(scores[0], "홍길동", 100, 90, 80);
        Score.init(scores[1], "임꺽정", 80, 80, 80);
        Score.init(scores[2], "유관순", 100, 100, 100);
        
        //: 학생 성적을 출력한다.
        for (Score s : scores) {
            Score.print(s);
        }
        
        
    }
}




