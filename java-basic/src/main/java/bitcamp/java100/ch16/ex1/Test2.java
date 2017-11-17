package bitcamp.java100.ch16.ex1;

public class Test2 {


    static class MyThread extends Thread {

        @Override
        public void run() {

            for (int i = 0; i < 10000; i++){
                System.out.println("MyThread = > " + i);
            }
        }
    }

    public static void main(String[] args) {
        
        MyThread t = new MyThread();
        
        // run() 메서드를 "main" 스레드와 별개로 실행한다.
        // 스레드를 분리하여 실행하는 즉시 리턴한다.
        t.start(); 
        
        for (int i = 0; i< 10000; i++) {
            System.out.println(i);
        }
    }
}
