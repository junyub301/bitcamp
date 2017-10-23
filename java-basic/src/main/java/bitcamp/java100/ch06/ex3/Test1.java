package bitcamp.java100.ch06.ex3;

import java.io.Console;

public class Test1 {

    public static void main(String[] args) {

        System.console().readLine("계속 실행하려면 엔터를 치세요 ");

        System.out.println(MyClass.v1);

        MyClass.v1 += 200;

        System.console().readLine("계속 실행하려면 엔터를 치세요 ");

        System.out.println(MyClass.v1);


    }

}
