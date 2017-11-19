package bitcamp.java100.ch02;

public class Test16_4 {
      
    public static void main(String[] args){

        int i = 0;
        while (i < 5) 
            System.out.println(i++);
        
        System.out.println("------------------------");
        
        i = 0;
        while (i < 5) {
            System.out.print("=> ");
            System.out.println(i);
            i++;
        }
        
        System.out.println("------------------------");
        
        i = 1;
        while (i <= 5) {
            System.out.println(i);
            i++;
        }
        System.out.println("------------------------");
        
        i = 1;
        while (i <= 5) {
            int count = 1;
            while (count <= i) {
                System.out.print("*");
                count++;
            }
            System.out.println();
            i += 2;
        }
        
        System.out.println("------------------------");
        
        i = 1;
        while (i <= 5) {
            int count = (5 - i) / 2;
            while (count > 0) {
                System.out.print(" ");
                count--;
            }
            count = 1; 
            while (count <= i) {
                System.out.print("*");
                count++;
            }
            System.out.println();
            i += 2;
        }

        System.out.println("------------------------");
        
        i = 5;
        while (i >= 1) {
            int count = (5 - i) / 2;
            while (count > 0) {
                System.out.print(" ");
                count--;
            }
            count = 1; 
            while (count <= i) {
                System.out.print("*");
                count++;
            }
            System.out.println();
            i -= 2;
        }
        
        
        
        
        System.out.println("------------------------");
        int a = 456156;
        int[] cnt = new int[10];
        while (a > 0) {
            System.out.printf("%d ",a % 10);
            cnt[a % 10]++;
            a /= 10;
        }
        
        System.out.println();
        int b = 0;
        
        while (b < cnt.length) {
            System.out.printf("%d = %d\n",b, cnt[b]);
            b++;
        }
        
        
    }

}