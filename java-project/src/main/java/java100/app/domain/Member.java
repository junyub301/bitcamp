package java100.app.domain;
import java.sql.Date;

public class Member {
    protected int no;
    protected String name;
    protected String email;
    protected String pwd;
    protected Date createdDate;

    //: ### 생성자 

    public Member() {}

    public Member(int no, String name, String email) {
        this.no = no;
        this.name = name;
        this.email = email;
        
    }
    
   
  

    @Override
    public String toString() {
        return "Member [no=" + no + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", createdDate="
                + createdDate + "]";
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
