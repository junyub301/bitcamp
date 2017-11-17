package bitcamp.java100.ch16.ex1;

public class Test3 {


    static class MyRunnable implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < 10000; i++){
                System.out.println("MyThread = > " + i);
            }
        }
    }

    public static void main(String[] args) {
        
        Thread t = new Thread(new MyRunnable());

        // 생성자 파라미터로 받은 MyRunnable 객체의 run() 메서드를 독립적으로 실행한다.
        // 그리고 즉시 리턴!
        t.start(); 
        
        for (int i = 0; i< 10000; i++) {
            System.out.println(i);
        }
    }
}
