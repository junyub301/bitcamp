package java100.app;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

import java100.app.control.BoardController;
import java100.app.control.Controller;
import java100.app.control.MemberController;
import java100.app.control.RoomController;
import java100.app.control.ScoreController;

//01026344150
//jinyoun.eom@gmail.com

public class App {
    
    static HashMap<String,Controller> controllerMap = new HashMap<>();
    static Scanner keyScan = new Scanner(System.in);

    public static void main(String[] args) {
        controllerMap.put("1", new ScoreController("./data/score.csv"));
        controllerMap.put("2", new MemberController("./data/member.csv"));
        controllerMap.put("3", new BoardController("./data/board.csv"));
        controllerMap.put("4", new RoomController("./data/room.csv"));

        loop:
            while(true) {
                System.out.print("명령> ");
                String[] input = keyScan.nextLine().toLowerCase().split(" ");

                try {
                    switch (input[0]) {
                    case "menu": doMenu(); break;
                    case "help": doHelp(); break;
                    case "quit": doQuit(); break loop;
                    case "go": doGo(input[1]); break;
                    default: doError();

                    }
                } catch (Exception e) {
                    System.out.println("명령처리중 오류 발생");
                }
                System.out.println();
            } // while
    }


    private static void doGo(String menuNo) {
        Controller controller = controllerMap.get(menuNo);
        
        if (controller == null) {
            System.out.println("해당 번호에 메뉴가 없습니다.");
            return;
        }
        controller.execute();

    }

    private static void doHelp() {
        System.out.println("[명령]");
        System.out.println("menu\t\t-메뉴 목록 출력한다.");
        System.out.println("go 번호\t\t-메뉴로 이동한다");
        System.out.println("quit\t\t-프로그램을 종료한다.");
    }

    private static void doMenu() {
        System.out.println("1 성적관리");
        System.out.println("2 회원관리");
        System.out.println("3 게시판");
        System.out.println("4 강의실");
    }

    private static void doError() {
        System.out.println("잘못된 명령입니다.");
    }

    private static void doQuit() {
        Collection<Controller> controls = controllerMap.values();
        for (Controller control : controls) {
            control.destroy();
        }
        System.out.println("프로그램을 종료합니다.");        
    }

}






