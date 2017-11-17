package bitcamp.java100.ch16.ex3;

public class Test1 {

    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(1000000);
        
        ATM t1 = new ATM("강남", account);
        ATM t2 = new ATM("종로", account);
        ATM t3 = new ATM("부산", account);
        ATM t4 = new ATM("광주", account);
        ATM t5 = new ATM("포항", account);
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    
        
        // JVM 은 모든 스레드가 모두 종료될 때까지 기다린다.
        System.out.println("인출 시작!");
    }
}
