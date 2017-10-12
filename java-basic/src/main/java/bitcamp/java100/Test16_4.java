package bitcamp.java100;


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
    }

}