package bitcamp.java100.ch14.ex4;

import java.io.Serializable;

public class Score4 implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private int kor;
    private int eng;
    private int math;
    private int music;
    private transient int sum;
    private transient float aver;
        
    public Score4() {}

    public Score4(String name, int kor, int eng, int math, int music) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.music = music;
        this.math = math;
        this.compute();
    }
    
    // 직렬화를 통해 읽어들인 점수를 가지고 다시 합계와 평균을 계산할 수 있도록 다음 메서드를 공개해야한다.
    public void compute() {
        this.sum = this.kor + this.eng + this.math + this.music;
        this.aver = this.sum / 4f;
    }

  


    @Override
    public String toString() {
        return "Score3 [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", music=" + music
                + ", sum=" + sum + ", aver=" + aver + "]";
    }

    public int getMusic() {
        return music;
    }

    public void setMusic(int music) {
        this.music = music;
        this.compute();
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getKor() {
        return kor;
    }


    public void setKor(int kor) {
        this.kor = kor;
        this.compute();
    }


    public int getEng() {
        return eng;
    }


    public void setEng(int eng) {
        this.eng = eng;
        this.compute();
    }


    public int getMath() {
        return math;
    }


    public void setMath(int math) {
        this.math = math;
        this.compute();
    }


    public int getSum() {
        return sum;
    }


    public float getAver() {
        return aver;
    }
    
    
}
