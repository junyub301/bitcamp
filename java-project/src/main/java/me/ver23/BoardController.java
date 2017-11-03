package me.ver23;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BoardController {
    static Scanner keyScan = new Scanner(System.in);
    private ArrayList<Board> list = new ArrayList<>();
    
    public void execute() {
        loop:
            while(true) {
                System.out.print("게시판> ");
                String input = keyScan.nextLine();

                switch (input) {
                case "add": this.doAdd(); break;
                case "list": this.doList(); break;
                case "view": this.doView(); break;
                case "delete": this.doDelete(); break;
                case "update": this.doUpdate(); break;
                case "main":; break loop;
                default:
                    System.out.println("해당 명령이 없습니다.");
                }

                System.out.println();
            } // while        
    }
    
    private void doList() {

        System.out.println("[회원 목록]");
        Iterator<Board> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().print();
        }

    }
    
    private void doAdd() {

        System.out.println("[회원 등록]");

        Board board;

        board = new Board();
        board.input();
        
        boolean isExist = false;
        Iterator<Board> iterator = list.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().num == board.num) {
                isExist = true;
                break;
            }
        }

        if (isExist) {
            System.out.println("이미 등록된 번호 입니다");
        } else
            list.add(board);
        
    }
    
    private void doView() {
        System.out.println("[회원 정보]");
        int num = Integer.parseInt(Prompts.input("번호? "));
        Board board = null;
        Iterator<Board> iterator = list.iterator();
        while (iterator.hasNext()) {
            Board temp = iterator.next();
            if(temp.num == num) {
                board = temp;
                break;
            }
        }

        if (board == null) {
            System.out.printf(" %d번게시물이  없습니다.\n", num);
        } else
            board.printDetail();        
    }
    
    private void doUpdate() {
        System.out.println("[성적 삭제]");

        int num = Integer.parseInt(Prompts.input("번호? "));
        Board board = null;
        Iterator<Board> iterator = list.iterator();
        while (iterator.hasNext()) {
            Board temp = iterator.next();
            if(temp.num == num) {
                board = temp;
                break;
            }
        }


        if (board == null) {
            System.out.printf("%d번 게시물이 없습니다.\n", num);
        } else
            board.update();        
    }
   
    
    private void doDelete() {
        System.out.println("[성적 삭제]");

        int num = Integer.parseInt(Prompts.input("번호? "));
        Board board = null;
        Iterator<Board> iterator = list.iterator();
        while (iterator.hasNext()) {
            Board temp = iterator.next();
            if(temp.num == num) {
                board = temp;
                break;
            }
        }


        if (board == null) {
            System.out.printf("%d번 게시물이 없습니다.\n", num);
        }  else {
            if (Prompts.confirm2("정말 삭제하겠습니까?(y/N)")) {
                list.remove(board);
                System.out.println("삭제했습니다.");
            }
            else System.out.println("삭제 취소했습니다.");
        }
    }
    
}
