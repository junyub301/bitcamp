package bitcamp.java100;

public class Test15_11_3 {
      
    public static void main(String[] args){
        
        int v = 87; //0b0101_0111
        
        System.out.println(v >> 1); // v / 2^1
        System.out.println(v >> 2); // v / 2^2
        System.out.println(v >> 3); // v / 2^3
        System.out.println(v >> 4); // v / 2^4
        
        v = -87;
        System.out.println(v >> 1); // v / 2^1
        System.out.println(v >> 2); // v / 2^2
        System.out.println(v >> 3); // v / 2^3
        System.out.println(v >> 4); // v / 2^4
        
        v = 87;
        System.out.println(v >>> 1); // v / 2^1
        System.out.println(v >>> 2); // v / 2^2
        System.out.println(v >>> 3); // v / 2^3
        System.out.println(v >>> 4); // v / 2^4
        
        v = -87;
        System.out.println(v >>> 1);
        System.out.println(v >>> 2); 
        System.out.println(v >>> 3); 
        System.out.println(v >>> 4); 
        
        v = 5;
        System.out.println(v << 1); // v * 2^1
        System.out.println(v << 2); // v * 2^2
        System.out.println(v << 3); // v * 2^3
        System.out.println(v << 4); // v * 2^4
        
        v = -5;
        System.out.println(v << 1); // v * 2^1
        System.out.println(v << 2); // v * 2^2
        System.out.println(v << 3); // v * 2^3
        System.out.println(v << 4); // v * 2^4
        
        
    }

}

