package java100.app.domain;

public class Score {
    
    protected int no;
    protected String name;
    protected int kor;
    protected int eng;
    protected int math;
    protected int sum;
    protected float aver;

    //: ### 생성자 

    public Score(){}

    public Score(int no, String name, int kor, int eng, int math) {
        this.no = no;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.compute();

    }

    
    @Override
    public String toString() {
        return "Score [no=" + no + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", "
                + "sum=" + sum + ", aver=" + aver + "]";
    }

    public int getNo() {
        return no;
    }
    
    public void setNo(int no) {
        this.no = no;
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





    private void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.aver = (float)this.sum / 3f;
    }


    //: ### 인스턴스 메서드
    //: 인스턴스 데이터를 다루는 메서드는 스태틱 보다 인스턴스 메서드로 선언해야 한다W.


}
