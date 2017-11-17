package bitcamp.java100.Test17_17.step2;

public class Test {

    static float area(int width, int height) {
        return (width * height) / 10000f;
    }
    
    static float pyeong(int width, int height) {
        return area(width, height)/3.3f;
    }
    public static void main(String[] args){

        int width = 390;
        int height = 420;
        
        
        System.out.println(area(width, height));
        
        System.out.println(pyeong(width, height));
    }

}