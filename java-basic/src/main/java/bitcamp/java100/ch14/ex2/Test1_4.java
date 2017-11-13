package bitcamp.java100.ch14.ex2;

public class Test1_4 {

    public static void main(String[] args) throws Exception {
        
        // 바이트 단위로 데이터를 읽어주는 객체
        MyBufferedInputStream in = new MyBufferedInputStream("sample/jls9.pdf");
        int count = 0;
        int b;
        long start = System.currentTimeMillis();
        while((b = in.read()) != -1) {
            count++;
        }
        long end = System.currentTimeMillis();
        System.out.printf("읽은 바이트 수 = %d\n", count);
        System.out.printf("걸린 시간 = %d\n", end - start);
        
        in.close();
    }

}
