package bitcamp.java100.ch14.ex1;

public class Test8_3 {

    static int sigma(int n) {
        if (n == 0)
            return 0;
        return n + sigma(n - 1);
    }

    public static void main(String[] args) throws Exception {

        System.out.println(sigma(10));
        
    }
}
