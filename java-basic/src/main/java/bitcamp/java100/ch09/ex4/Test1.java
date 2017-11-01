package bitcamp.java100.ch09.ex4;

public class Test1 {

    public static void main(String[] args) {
        Stack stack = new Stack();
        
        stack.push("홍길동");
        stack.push("임꺽정");
        stack.push("유관순");
        stack.push("안중근");
        stack.push("윤봉길");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push("홍길동");
        stack.push("임꺽정");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
