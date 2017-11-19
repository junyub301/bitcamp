package bitcamp.java100.ch03;
public class Test17_8 {

    static class Member {
        String name;
        int age;
        boolean working;
        float score;
        char level;
    }
    static Member m1() {
        Member ref = new Member();
        ref.name = "홍길동";
        ref.age = 20;
        ref.working = false;
        ref.score = 4.12f;
        ref.level = 'M'; //' ' : ''안의 문자 유니코드 값을 넣는 연산자
        
        return ref;
    }
    
    public static void main(String[] args){

        Member mem = m1();
        
        System.out.println(mem.name);
        System.out.println(mem.age);
        System.out.println(mem.working);
        System.out.println(mem.score);
        System.out.println(mem.level);
    }

}