package bitcamp.java100.ch07.ex5;

public class A {

/*    A(){
        // 모든 생성자는 첫 번째 문장으로 수퍼 클래스의 기본 생성자를 호출한다.
        // 다음은 A클래스의 수퍼클래스인 Object의 기본 생성자를 호출한 것이다.
        super();
    }*/

    // 만약 다음과 같이 생성자를 정의한다면 컴파일러가 기본 생성자를 추가하지 않는다.
    A() {
        // 수퍼 클래스의 기본생성자를 호출하는 문장이 생략되면, 컴파일러가 자동으로 첫번째 문장으로 다음을 추가한다.
        // super();
        // 따라서 반드시 수퍼 클래스의 생성자가 호출된다. 
        System.out.println("A() 생성자 실행");
    }


    A(String str){
        super(); // 생략해도 되고 직접 써도 된다.
        System.out.println("A(String) 생성자 실행");
    }

    // 수퍼 클래스 생성자를 첫 번째로 호출하지 않으면 컴파일 오류
    A(int i ){
        System.out.println("A(int) 생성자 실행");
        // super(); -> 컴파일 오류
    }

}


