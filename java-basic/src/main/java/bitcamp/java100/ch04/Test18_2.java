package bitcamp.java100.ch04;

public class Test18_2 {
      
   
    public static void main(String[] args){
        
        String s1;
        s1 = "ABC가각간";
        
        System.out.println(s1);
        
        String s2 = "ABC가각간";
        
        // 인스턴스가 다르기 때문에 주소도 다르다.
        if (s1 == s2) 
            System.out.println("s1 == s2");

        
    }
}