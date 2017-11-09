package java100.app.domain;
import java100.app.control.CSVFormatException;

public class Score {

    protected String name;
    protected int kor;
    protected int eng;
    protected int math;
    protected int sum;
    protected float aver;

    //: ### 생성자 

    public Score(){}

    public Score(String name, int kor, int eng, int math) {

        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.compute();

    }

    public Score(String csv) throws CSVFormatException {
        String[] rec = csv.split(",");
        if (rec.length < 4)
            throw new CSVFormatException("CSV 데이터 항목의 개수가 올바르지 않습니다.");

        try {
            this.name = rec[0];
            this.kor = Integer.parseInt(rec[1]);
            this.eng = Integer.parseInt(rec[2]);
            this.math = Integer.parseInt(rec[3]);
            this.compute();
        } catch (Exception e) {
            throw new CSVFormatException("CSV 데이터 항목의 형식이 올바르지 않습니다.");
        }
    }

    @Override
    public String toString() {
        return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + sum + ", aver="
                + aver + "]";
    }
    
    public String toCSVString() {
        return String.format("%s,%d,%d,%d,%d,%f", 
                this.getName(), 
                this.getKor(),
                this.getEng(), 
                this.getMath(), 
                this.getSum(), 
                this.getAver());
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
