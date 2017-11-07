package bitcamp.java100.ch12.ex3;

public  class Test1 implements Protocol3 {

    @Override
    public void m1() {
        System.out.println("m1()");
    }

    @Override
    public void m2(int v) {
        System.out.println("m2()");
    }

    @Override
    public void m3(String v) {
        System.out.println("m3()");
    }

}
