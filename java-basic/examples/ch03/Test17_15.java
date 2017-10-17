package bitcamp.java100;

public class Test17_15 {

   static int m1() {
       int a = 100;
       int b = 200;
       int c = a + b;
       return c;
   }
   
   static int[] m2() {
       int[] arr = new int [3];
       arr[0] = 100;
       arr[1] = 200;
       arr[2] = 300;
       
       return arr;
   }
    public static void main(String[] args){
        int r1 = m1();
        
        System.out.println(r1);
        
        System.out.println("----------------------------------");
        int[] r2 = m2();
        for(int i : r2) {
            System.out.println(i);
        }
    }

}