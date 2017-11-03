package me.ver23;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ScoreController {

    private ArrayList<Score> list = new ArrayList<>();
    static Scanner keyScan = new Scanner(System.in);

    public void execute() {
        loop:
            while(true) {
                System.out.print("성적관리> ");
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

    private void doUpdate() {
        System.out.println("[성적 정보 변경]");
        String name = Prompts.input("이름? ");

        Score score = null;
        Iterator<Score> iterator = list.iterator();
        while (iterator.hasNext()) {
            Score temp = iterator.next();
            if(temp.name.equals(name)) {
                score = temp;
                break;
            }
        }

        if (score == null) {
            System.out.printf("'%s'의 성적 정보가 없습니다.\n", name);
        } else {
            score.update();
        }        
    }

    private void doDelete() {
        System.out.println("[성적 삭제]");

        String name = Prompts.input("이름? ");
        Score score = null;
        Iterator<Score> iterator = list.iterator();
        while (iterator.hasNext()) {
            Score temp = iterator.next();
            if(temp.name.equals(name)) {
                score = temp;
                break;
            }
        }

        if (score == null) {
            System.out.printf("'%s'의 성적 정보가 없습니다.\n", name);
        } else {
            if (Prompts.confirm2("정말 삭제하겠습니까?(y/N)")) {
                list.remove(score);
                System.out.println("삭제했습니다.");
            }
            else System.out.println("삭제 취소했습니다.");
        }
    }

    private void doView() {
        System.out.println("[성적 정보]");
        String name = Prompts.input("이름? ");
        Score score = null;
        Iterator<Score> iterator = list.iterator();
        while (iterator.hasNext()) {
            Score temp = iterator.next();
            if(temp.name.equals(name)) {
                score = temp;
                break;
            }
        }

        if (score == null) {
            System.out.printf("'%s'의 성적 정보가 없습니다.\n", name);
        } else
            score.print();        
    }

    private void doList() {

        System.out.println("[성적 목록]");
        Iterator<Score> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().list();
        }

    }

    private void doAdd() {

        System.out.println("[성적 등록]");

        Score score;
        while(true) {

            score = new Score();
            score.input();

            list.add(score);

            if (!Prompts.confirm("계속하시겠습니까?(Y/n)"))
                break;
        }
    }
    
    

}
