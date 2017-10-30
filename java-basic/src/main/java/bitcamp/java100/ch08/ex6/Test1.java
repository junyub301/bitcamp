package bitcamp.java100.ch08.ex6;

import java.util.ArrayList;
import java.util.HashSet;

public class Test1 {
    
    public static void main(String[] args) {
        Score s1 = new Score(1, "홍길동", 100, 100, 100);
        Score s2 = new Score(1, "홍길동", 100, 100, 100);

        // ArrayList : 객체의 주소를 보관한다. 
        // 같은객체(인스턴스 주소가 같을 경우, equals()로 비교했을때 리턴값이 true, HashCode()값이 같을 경우)를 중복해서 보관할 수 있다.
        ArrayList list = new ArrayList();
        list.add(s1);
        list.add(s1);
        
        System.out.println(list.size());
        System.out.println(list.get(0).toString());
        System.out.println(list.get(1).toString());
        
        System.out.println("----------------------------------------------------------------------------");
        
        // HashSet : ArrayList처럼 객체의 주소를 보관하는 용도로 사용, 
        // ArrayList와 다른점 
        // 같은 객체(인스턴스 주소가 같을 경우, equals()로 비교했을때 리턴값이 true, HashCode()값이 같을 경우)를 중복 저장 안함.
        HashSet set = new HashSet();
        set.add(s1);
        set.add(s1);
        System.out.println(set.size());
        System.out.println(set.toString());
        
        System.out.println("----------------------------------------------------------------------------");

        set.add(s2);
        System.out.println(set.size());
        System.out.println(set.toString());
        
        System.out.println("----------------------------------------------------------------------------");

        System.out.printf("s1.equals(s2) = %b\n",s1.equals(s2));
        System.out.printf("s1.hashCode() = %d\n",s1.hashCode());
        System.out.printf("s2.hashCode() = %d\n",s2.hashCode());

    }

}
