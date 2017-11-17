package bitcamp.java100.Test17_17.step6;

public class Rect {
    int width;
    int height;
    
    float area() {
        return (this.width * this.height) / 10000f;
    }
    
    float pyeong() {
        return (this.width * this.height) / 10000f / 3.3f;
    }

}

// 인스턴스 메서드 : 그 인스턴스의 데이터만 다루는 전용 메서드