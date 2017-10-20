package bitcamp.java100;


public class Test18_4 {
      
   
    public static void main(String[] args){
        
        // constants pool에 생성
        String s1 = "ABC가각간";
        // heap에 생성
        String s2 = new String("ABC가각간");
        
        // 주소가 같은지 비교 - > 인스턴스가 같은지 비교
        if (s1 != s2) System.out.println("s1 != s2");
        
        // 내용물이 같은지 비교 -> String 클래스의 인스턴스 메서드인 equals()사용
        if (s1.equals(s2)) System.out.println("s1과 s2의 내용물이 같다");
    
    }
}