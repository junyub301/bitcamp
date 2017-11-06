package java100.app.domain;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

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
    
    
    @Override
    public String toString() {
        return "Member [name=" + name + ", email=" + email + ", pwd=" + pwd + "]";
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
