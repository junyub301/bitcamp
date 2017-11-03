package me.ver23;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    protected int num;
    protected String title;
    protected String content;
    Date sqlDate = new Date(utilDate.getTime());
    
    private ArrayList<Board> list = new ArrayList<>();
    
    public Board() {}
    
    public Board(int num, String title, String content) {
        this.num = num;
        this.title = title;
        this.content = content;
        
    }
    

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("번호? ");
        this.num = Integer.parseInt(scanner.nextLine());
        
        System.out.print("제목? ");
        this.title = scanner.nextLine();

        System.out.print("내용? ");
        this.content = scanner.nextLine();
    }
        
   
    
    public void print() {
        
        System.out.printf("%s ",this.title);
        System.out.printf("%1$tY-%1$tm-%1$te\n", 
                new java.util.Date());
    }
    
    public void printDetail() {
        System.out.printf("제목: %s\n내용: %s\n",  
                this.title, 
                this.content);
    }
    
    public void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("제목?(%s) ", this.title);
        String title = scanner.nextLine();
        if (title.isEmpty()) {
            title = this.title;
        }
        
        System.out.printf("내용?(%s) ", this.content);
        String content = scanner.nextLine();
        if (content.isEmpty()) {
            content = " ";
        }

        if (Prompts.confirm2("변경하시겠습니까?(y/N) ")) {
            this.title = title;
            this.content = content;
            System.out.println("변경하였습니다.");
        } else {
            System.out.println("변경 취소하였습니다.");
        }

    }

}

