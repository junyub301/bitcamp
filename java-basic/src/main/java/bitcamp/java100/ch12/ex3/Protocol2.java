package bitcamp.java100.ch12.ex3;

public interface Protocol2 {
  
    public static final float PI =3.14159f;
    
    // public 생략 가능
    static final int AA = 100;
    
    // static 생략 가능
    final int BB = 200;
    
    // final 생략 가능
    int CC = 300; // = public static final int CC = 300;
    
    // 생략하면 컴파일러가 자동으로 public static final을 붙인다.
    
}
