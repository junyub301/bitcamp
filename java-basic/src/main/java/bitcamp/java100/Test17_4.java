package bitcamp.java100;


public class Test17_4 {

    static void m1(int... valuse) {
        System.out.println("아규먼트 개수: " + valuse.length);
        for (int v : valuse) {
            System.out.println(v);
        }
        System.out.println("-------------------------");
    }
    // 가변길이 파라미터는 오직 "한 개만" 사용할 수 있다.
    // static void m2(int...values, int...is values2) {} -> 컴파일 오류
    
    // 일반 파라미터와 같이 쓸 때는 반드시 일반 파라미터가 먼저 와야한다. -> 가변 길이 파라미터는 무조건 "제일 뒤"
    static void m3(String name, int age, int... valuse) {}
    // static void m4(int... valuse, String name, int age) {}
    // static void m5(String name, int... valuse, String age) {}

    static void sum(int... values) {
        int s = 0;
        for (int v: values) {
            s += v;
        }
        System.out.printf("합계: %d\n", s);
    }
    public static void main(String[] args){
        m1();
        m1(10);
        m1(10, 20);
        m1(10, 20, 30);
        
        sum(100,20,30,11,340);
    }

}