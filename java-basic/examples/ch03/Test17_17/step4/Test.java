package bitcamp.java100.Test17_17.step4;

public class Test {

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