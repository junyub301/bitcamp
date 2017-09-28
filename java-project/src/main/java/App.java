
public class App {
  
    public static void main(String[] args) {
        /* 여러명의 성적을 저장하고 출력
        출력 내용
        홍길동, 100, 90, 80, 270, 90.0
        임꺽정, 80, 80, 80, 240, 80.0
        유관순, 100, 100, 100, 300, 100.0 */
 
        String[] name = {"홍길동","임꺽정","유관순"};
        int[] kor = {100,80,100};
        int[] eng = {90,80,100};
        int[] math = {80,80,100};

        for(int i=0; i<name.length;i++ ){
            int sum = kor[i] + eng[i] + math[i];
            float avg = sum / 3.0f;
            System.out.printf("%-4s%4d%4d%4d%4d%4.1f\n", name[i], kor[i], eng[i], math[i], sum, avg);
    }
    
       
    }
}
