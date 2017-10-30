package bitcamp.java100.ch08.ex6;

import java.util.ArrayList;
import java.util.HashSet;

public class Test2 {
    
    public static void main(String[] args) {
        Score s1 = new Score(1, "홍길동", 100, 100, 100);
        Score s2 = new Score(1, "홍길동", 100, 100, 100);

        
        HashSet set = new HashSet();

        set.add(s1);
        set.add(s2);

        System.out.println(set.size());
        System.out.printf("s1.equals(s2) = %b\n",s1.equals(s2));
        System.out.printf("s1.hashCode() = %d\n",s1.hashCode());
        System.out.printf("s2.hashCode() = %d\n",s2.hashCode());
        
        System.out.println("----------------------------------------------------------------------------");

        Score2 s3 = new Score2(1, "홍길동", 100, 100, 100);
        Score2 s4 = new Score2(1, "홍길동", 100, 100, 100);
        
        
        HashSet set2 = new HashSet();
        
        set2.add(s3);
        set2.add(s4);
        
        System.out.println(set2.size());
        System.out.printf("s3.equals(s4) = %b\n",s3.equals(s4));
        System.out.printf("s3.hashCode() = %d\n",s3.hashCode());
        System.out.printf("s4.hashCode() = %d\n",s4.hashCode());
        
        
        System.out.println("----------------------------------------------------------------------------");
        
    }

}
