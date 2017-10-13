package bitcamp.java100;

public class Test17_11 {

    static int m1(int p) {
        return m2(p + 1);
    }
    
    static int m2(int q) {
        return m3(q + 1);
    }
    
    static int m3(int r) {
        return m4(r + 1);
    }
    
    static int m4(int s) {
        return s + 1;
    }
    
    public static void main(String[] args){

        int result = m1(1);
        System.out.println(result);
    }

}