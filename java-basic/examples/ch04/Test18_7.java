package bitcamp.java100;


public class Test18_7 {
      
   
    public static void main(String[] args) throws Exception {
        
        // Immutable 객체
        String s1 = "Hello!";

        String s2 = s1.replace("l", "x");
        
        System.out.println(s1);
        System.out.println(s2);
        
        // Mutable 객체
        StringBuffer sb1 = new StringBuffer("Hello!");
        // append(추가할 문자열) : 원본 문자열 뒤에 문자열을 덧붙인다.
        sb1.append(" World!");
        System.out.println(sb1);
        
        sb1.replace(2, 4, "xx");
        System.out.println(sb1);
    }
}