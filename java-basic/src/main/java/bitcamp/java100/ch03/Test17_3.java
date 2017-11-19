package bitcamp.java100.ch03;

public class Test17_3 {
    
    // 파라미터(parameter) : 호출한 쪽에서 보낸 값을 저장하기 위해 선언한 로컬 변수
    static void m1(String name) {

        System.out.printf("%s님 반갑습니다.\n",name);
    }

    static void m2(String name, int age) {

        System.out.printf("%s(%d)님 반갑습니다.\n",name,age);
    }

    public static void main(String[] args){
        // 아규먼트(argument) : 메서드를 호출할 때 파라미터에 넘기는 값
        m1("홍길동");
        m1("임꺽정");
        m1("유관순");

        m2("홍길동",20);
        m2("임꺽정",30);
        m2("유관순",16);



    }

}