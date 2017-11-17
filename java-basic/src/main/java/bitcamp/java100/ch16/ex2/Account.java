package bitcamp.java100.ch16.ex2;

public class Account {

    long balance;

    public long deposit(long money) {
        long temp = this.balance;
        temp += money;
        this.balance = temp;
        return this.balance;
    }

    public long withdraw(long money) {
        long temp = this.balance;
        delay();
        if ((temp - money) < 0)
            return 0;
        delay();
        temp -= money;
        delay();
        this.balance = temp;
        delay();
        return money;
    }

    private void delay() {
        double value = 1;
        for (int i = 0; i < 10; i++) {
            value *= Math.random();
        }
    }
}
