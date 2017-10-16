package bitcamp.java100;

public class Test12_9 {
      
    public static void main(String[] args){

        char c1;

        c1 = 44032; 

        char c2 = 0xac00;

        System.out.println(c1);
        System.out.println(c2);

        char n1=0xae40, n2 = 0xc900, n3=0xc5fd;
        System.out.printf("%c %c %c\n", n1, n2, n3);

        n1 = '홍'; // 해당 글자의 유니코드 값을 리턴한다.
        n2 = '길';
        n3 = '동';
        System.out.printf("%c %c %c\n", n1, n2, n3);

        char x = '7';
        int num;
        num =x -'0';

        System.out.println(num);
        
    
    }

}