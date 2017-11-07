package bitcamp.java100.ch06;

public class Sedan extends Car {

    
    boolean isOpen;

    @Override
    public void run() {
        if (isOpen) {
            System.out.println("시원하게 달린다");
        } else {
            System.out.println("포근하게 달린다.");
        }
    }

    public void openSunroof() {
        isOpen = true;
        System.out.println("썬루프 연다.");
    }

    public void closeSunroof() {
        isOpen = false;
        System.out.println("썬루프 닫는다.");
    }
}
