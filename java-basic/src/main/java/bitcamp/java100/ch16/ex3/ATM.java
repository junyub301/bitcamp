package bitcamp.java100.ch16.ex3;

public class ATM extends Thread {

    Account account;
    
    public ATM(String name, Account account) {
        super(name);
        this.account = account;
    }
    
    @Override
    public void run() {
        long sum = 0;
        
        while (true) {
            long money = account.withdraw(100);
            if (money == 0)
                break;
            sum += money;
        }
        
        System.out.printf("%s = %d원\n", this.getName(), sum);
    }
}
