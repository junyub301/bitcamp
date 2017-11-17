package bitcamp.java100.ch16.ex1;

public class Test1 {

    public static void main(String[] args) {
        
        Thread t1 = Thread.currentThread();
        System.out.println(t1.getName());
        
        ThreadGroup g1 = t1.getThreadGroup();
        System.out.println(g1.getName());
        
        ThreadGroup g2 = g1.getParent();
        System.out.println(g2.getName());
        
        ThreadGroup g3 = g2.getParent();
        System.out.println(g3);
        
        System.out.println("---------------------------------------------");

        ThreadGroup[] groups = new ThreadGroup[10];
        
        int len = g2.enumerate(groups, false);
        
        for (int i = 0; i < len; i++) {
            System.out.println(groups[i].getName());
        }
        System.out.println("---------------------------------------------");
        
        len = g1.enumerate(groups, false);
        
        for (int i = 0; i < len; i++) {
            System.out.println(groups[i].getName());
        }
        
        System.out.println("---------------------------------------------");
        Thread[] threads = new Thread[10];
        len = g2.enumerate(threads, false);
        for(int i = 0; i < len; i++) {
            System.out.println(threads[i].getName());
        }
        
        System.out.println("---------------------------------------------");
        len = g1.enumerate(threads, false);
        for(int i = 0; i < len; i++) {
            System.out.println(threads[i].getName());
        }
        
        
    
    }
}
