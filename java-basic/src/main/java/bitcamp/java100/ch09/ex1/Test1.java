package bitcamp.java100.ch09.ex1;

public class Test1 {

    public static void main(String[] args) {
        Object[] arr = new Object[10000];
        
        int cursor = 0;
        
        arr[cursor++] = new String("홍길동");
        arr[cursor++] = new Integer(100);
        arr[cursor++] = 80; // new Integer(80) => Auto-boxing
        arr[cursor++] = 70;
        arr[cursor++] = 250;
        arr[cursor++] = 250 / 3f;
        arr[cursor++] ="임꺽정";
        arr[cursor++] = 80;
        arr[cursor++] = 80; // new Integer(80) => Auto-boxing
        arr[cursor++] = 80;
        arr[cursor++] = 240;
        arr[cursor++] = 240 / 3f;
        
        for (int i = 0; i < cursor; i++)
        {
            System.out.println(arr[i]);
        }
    }

}
