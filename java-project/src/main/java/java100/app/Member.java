package java100.app;
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
    
    public void print() {
        System.out.printf("%-4s,%s\n",  
                this.name, 
                this.email);
    }
    
    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("이름? ");
        this.name = scanner.nextLine();

        System.out.print("이메일? ");
        this.email = scanner.nextLine();

        System.out.print("암호? ");
        this.pwd = scanner.nextLine();
        

    }
    
    public void printDetail() {
        System.out.printf("이름: %s\n이메일: %s\n암호: %s\n",  
                this.name, 
                this.email,
                this.pwd);
    }
    
    public void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("이름?(%s) ", this.name);
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            name = this.name;
        }
        
        System.out.printf("암호?(%s) ", this.pwd);
        String pwd = scanner.nextLine();
        if (pwd.isEmpty()) {
            pwd = this.pwd;
        }

        if (Prompts.confirm2("변경하시겠습니까?(y/N) ")) {
            this.name = name;
            this.pwd = pwd;
            System.out.println("변경하였습니다.");
        } else {
            System.out.println("변경 취소하였습니다.");
        }

    }

    //: ### 인스턴스 메서드
    //: 인스턴스 데이터를 다루는 메서드는 스태틱 보다 인스턴스 메서드로 선언해야 한다W.


}
