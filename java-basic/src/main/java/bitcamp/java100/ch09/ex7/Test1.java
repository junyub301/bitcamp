package bitcamp.java100.ch09.ex7;

import java.util.ArrayList;

public class Test1 {

    public static void main(String[] args) {
        
        ArrayList<String> list = new ArrayList<>();
        
        list.add(new String("홍길동"));
        list.add(new String("임꺽정"));
        list.add(new String("유관순"));
        
        System.out.println(list.size());
        
        for (int i = 0; i < list.size(); i++)
        {
            System.out.printf("%s ",list.get(i));
        }
        System.out.println();
        
        for (String s : list)
            System.out.printf("%s ", s);
        System.out.println();
    }
}
