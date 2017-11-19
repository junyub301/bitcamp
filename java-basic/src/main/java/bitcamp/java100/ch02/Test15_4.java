package bitcamp.java100.ch02;
public class Test15_4 {
      
    public static void main(String[] args){
        
        float f1 = 3.141592f;
        int i1 = 7654321;
        System.out.printf("f1 = %f i1 = %d\n",f1,i1);
        double r1 = f1 + i1;
        System.out.println(r1);
        r1 = f1 + (double) i1;
        System.out.println(r1);
    }

}

// 형변환(Type conversion | Type casting)