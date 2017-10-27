package me;
import java.util.Scanner;

//: ## 생성자와 인스턴스 메서드 도입
//: - init() 메서드 대신 생성자를 이용하여 인스턴스를 초기화시킨다.
//: - print() 메서드는 인스턴스 데이터를 다루기 때문에 스태틱 메서드 대신
//:   인스턴스 메서드로 전환한다. 
public class Score3 {

    String name;
    int[] subjects; 
    int sum;
    float aver;

    //: ### 생성자 
    
    Score3(){
        this.subjects = new int[3];
    }
    
    Score3(String name, int kor, int eng, int math) {
        this.name = name;
        this.subjects = new int[]{kor, eng, math};

//        ScoreDao3.compute(this);
    }
    

    //: ### 인스턴스 메서드
    //: 인스턴스 데이터를 다루는 메서드는 스태틱 보다 인스턴스 메서드로 선언해야 한다.
   
   

   
}
