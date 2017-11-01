package bitcamp.java100.ch09.ex7;

import java.util.ArrayList;

public class Test2 {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        String s1 = "홍길동";
        String s2 = "임꺽정";
        String s3 = "유관순";

        list.add(s1);
        list.add(s2);
        list.add(s3);

        list.add(s1);
        list.add(s2);

        list.add(null);
        list.add(null);
        
        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++)
        {
            System.out.printf("%s ",list.get(i));
        }
        System.out.println();
    }
}
