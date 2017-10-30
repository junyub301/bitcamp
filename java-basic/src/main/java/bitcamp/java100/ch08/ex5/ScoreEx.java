package bitcamp.java100.ch08.ex5;

public class ScoreEx extends Score {

    int sci;
    int soc;
    
    public ScoreEx() {}
    
    public ScoreEx(int no, String name, int kor, int eng, int math, int sci, int soc) {
        super(no, name, kor, eng, math);
        this.sci = sci;
        this.soc = soc;
        
        this.compute();
        
    }

    public int getSci() {
        return sci;
    }

    public void setSci(int sci) {
        this.sci = sci;
        this.compute();
    }

    public int getSoc() {
        return soc;
    }

    public void setSoc(int soc) {
        this.soc = soc;
        this.compute();
    }
    
    @Override
    protected void compute() {
        // TODO Auto-generated method stub
        ;
    }
    
    
}
