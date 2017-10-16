package bitcamp.java100;


public class Test17_1 {
      
    static class Score {
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float avg;
        
    }
    public static void main(String[] args){
        
        
        Score s1 = new Score();
        s1.name = "홍길동";
        s1.kor = 90;
        s1.eng = 100;
        s1.math = 100;
        s1.sum = s1.kor + s1.eng + s1.math;
        s1.avg = s1.sum/3f;
        
        Score s2 = new Score();
        s2.name = "임꺽정";
        s2.kor = 100;
        s2.eng = 70;
        s2.math = 50;
        s2.sum = s2.kor + s2.eng + s2.math;
        s2.avg = s2.sum/3f;
        
        Score s3 = createScore("유관순", 100, 100, 100);
        Score s4 = createScore("안중근", 90, 90, 90);
        Score s5 = createScore("윤봉길", 80, 80, 80);
        

    }

    static Score createScore(String name, int kor, int eng, int math) {
        
        Score s = new Score();
        
        s.name = name;
        s.kor = kor;
        s.eng = eng;
        s.math = math;
        s.sum = kor + eng + math;
        s.avg = s.sum/3f;
        
        return s;
    }
}