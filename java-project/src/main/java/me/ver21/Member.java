package me.ver21;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Member {

    protected String name;
    protected String email;
    protected String pwd;

    //: ### 생성자 

    public Member(){
    }

    public Member(String name, String email, String pwd) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
    }
    
    public void input() {
        ArrayList<Member> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("이름? ");
        this.name = scanner.nextLine();

        System.out.print("이메일? ");
        this.email = scanner.nextLine();

        System.out.print("암호? ");
        this.pwd = scanner.nextLine();
        
    }

    public void print() {
       System.out.printf("이름: %s\n이메일: %s\n암호: %s\n", this.name, this.email, this.pwd);
    }
    
    public void list() {
        System.out.printf("%s, %s\n", this.name, this.email);
     }
    
    public void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("이름?(%s) ", name);
        String upName = this.name;
        try {
            upName = scanner.nextLine();
        } catch (Exception e) {}

        System.out.printf("이메일?(%s) ", email);
        String upEmail = this.email;
        try {
            upEmail = scanner.nextLine();
        } catch (Exception e) {}
        
        System.out.printf("암호?(%s) ", pwd);
        String upPwd = this.email;
        try {
            upPwd = scanner.nextLine();
        } catch (Exception e) {}
        

        if (confirm2("변경하시겠습니까?(y/N) ")) {
            this.name = upName;
            this.email = upEmail;
            this.pwd = upPwd;
            
            System.out.println("변경하였습니다.");
        } else {
            System.out.println("변경 취소하였습니다.");
        }

    }
    static boolean confirm2(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        String response = sc.nextLine().toLowerCase();

        if(response.equals("n") || response.equals("N") || response.equals("") ) {
            return false;
        }
        return true;
    }

  



    //: ### 인스턴스 메서드
    //: 인스턴스 데이터를 다루는 메서드는 스태틱 보다 인스턴스 메서드로 선언해야 한다W.


}
