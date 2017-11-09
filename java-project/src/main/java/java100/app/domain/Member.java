package java100.app.domain;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import java100.app.control.CSVFormatException;

public class Member {

    protected String name;
    protected String email;
    protected String pwd;

    //: ### 생성자 

    public Member() {}

    public Member(String name, String email, String pwd) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
    }
    
    public Member(String csv) throws CSVFormatException{
        String[] rec = csv.split(",");
        if (rec.length != 3)
            throw new CSVFormatException("CSV 데이터 항목의 개수가 올바르지 않습니다.");

            this.name = rec[0];
            this.email = rec[1];
            this.pwd = rec[2];
    }
    
    @Override
    public String toString() {
        return "Member [name=" + name + ", email=" + email + ", pwd=" + pwd + "]";
    }

    public String toCSVString() {
        return String.format("%s,%s,%s", 
                this.getName(), 
                this.getEmail(),
                this.getPwd());
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    
 

    //: ### 인스턴스 메서드
    //: 인스턴스 데이터를 다루는 메서드는 스태틱 보다 인스턴스 메서드로 선언해야 한다W.


}
