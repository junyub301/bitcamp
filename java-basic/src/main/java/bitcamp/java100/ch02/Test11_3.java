package bitcamp.java100.ch02;
//기계가 이해할 수 있는 바이트 코드로 변환하는것을 컴파일이라고 한다. 
public class Test11_3 {
      
    public static void main(String[] args){

        System.out.print("ABC");
        System.out.print('\b'); 
        System.out.println("123");
        
        System.out.println("ABC\t123"); // Tab
        System.out.println("ABC\u0009123");
        System.out.println("ABC\n123"); // Line Feed(LF : 0x000a)
        System.out.println("ABC\r123"); // Carrage Return(CR : 0x000d) 커서를 제일 앞으로   
        System.out.println("ABC\f123"); // Form Feed : 커서를 다음줄로 이동한다.
        System.out.println("ABC\"123"); // double quote
        System.out.println('\''); // sigle quote
        System.out.println('"'); // double quote
        System.out.println("c:\\workspace\\test");

    }
        
    }