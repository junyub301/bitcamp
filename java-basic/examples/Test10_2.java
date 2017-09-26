package bitcamp.java100;

public class Test10_2 {
      
    public static void main(String[] args){
       
       /* System -> 클래스라고 부른다.
          out -> 객체(object) = 실체(instance)
          println -> 기능 */
  
          System.out.println("Hello!");
  
          /* 도구함에 있는 기능 바로 이용하기
            - 어떤 기능은 인스턴스가 있어야만 사용가능하다.
            - 어떤 기능은 클래스만 있으면 사용가능하다 */
            
          long currMillis = System.currentTimeMillis();
          System.out.println(currMillis);
    }



}