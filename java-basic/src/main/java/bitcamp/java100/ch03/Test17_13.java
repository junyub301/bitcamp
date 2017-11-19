package bitcamp.java100.ch03;
public class Test17_13 {

    static void m1(int value) {
        value += 50;
        m2(value);
        System.out.printf("m1() : %d\n",value);
    }
    
    static void m2(int value) {
        value += 40;
        m3(value);
        System.out.printf("m2() : %d\n",value);
    }
    
    static void m3(int value) {
        value += 30;
        System.out.printf("m3() : %d\n",value);
    }
    
    public static void main(String[] args){
        int value = 100;
        m1(value);
        System.out.printf("main() : %d\n", value);
    }

}