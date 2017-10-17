package bitcamp.java100.Test17_17.step3;

public class Test {

    static class Rect {
        int width;
        int height;
    }
    static float area(Rect r) {
        return (r.width * r.height) / 10000f;
    }
    
    static float pyeong(Rect r) {
        return (r.width * r.height) / 10000f / 3.3f;
    }
    public static void main(String[] args){

        Rect rect;
        rect = new Rect();
        rect.width = 390;
        rect.height = 420;
        
        System.out.println(area(rect));
        
        System.out.println(pyeong(rect));
    }

}