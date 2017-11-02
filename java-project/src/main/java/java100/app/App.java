package java100.app;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



//01026344150
//jinyoun.eom@gmail.com

public class App {

    static Scanner keyScan = new Scanner(System.in);

    static String prompt(String message ) {
        Scanner KeyScan = new Scanner(System.in);
        System.out.print(message);
        return keyScan.nextLine();
    }

    static boolean confirm(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        String response = sc.nextLine().toLowerCase();

        if(response.equals("y") || response.equals("yes") || response.equals("") ) {
            return true;
        }
        return false;
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

    public static void main(String[] args) {

        ArrayList<Score> list = new ArrayList<>();
        Iterator<Score> iterator;

        loop:
            while(true) {
                System.out.print("성적관리> ");
                String input = keyScan.nextLine();
                String name = null;
                Score score = null;
                switch (input) {

                case "add":
                    System.out.println("[학생 등록]");

                    while(true) {

                        score = new Score();
                        score.input();

                        list.add(score);

                        if (!confirm("계속하시겠습니까?(Y/n)"))
                            break;
                    }

                    break;
                case "list":
                    System.out.println("[학생 목록]");
                    iterator = list.iterator();
                    while (iterator.hasNext()) {
                        iterator.next().list();
                    }

                    break;
                case "view":
                    System.out.println("[학생 정보]");
                    name = prompt("이름? ");
                    score = null;
                    iterator = list.iterator();
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

                    break;
                case "delete":
                    System.out.println("[학생 삭제]");

                    name = prompt("이름? ");
                    score = null;
                    iterator = list.iterator();
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
                        if (confirm2("정말 삭제하겠습니까?(y/N)")) {
                            list.remove(score);
                            System.out.println("삭제했습니다.");
                        }
                        else System.out.println("삭제 취소했습니다.");
                    }

                    break;
                case "update":
                    System.out.println("[학생 정보 변경]");
                    name = prompt("이름? ");

                    score = null;
                    iterator = list.iterator();
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
                    break;
                case "quit":
                    System.out.println("프로그램을 종료합니다.");
                    break loop;
                default:
                    System.out.println("실행할 수 없는 명령입니다.");        
                }

                System.out.println();

                //           
            }



    }

}









