package me;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



//01026344150
//jinyoun.eom@gmail.com

public class App {

    static boolean confirm(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        String response = sc.nextLine().toLowerCase();

        if(response.equals("y") || response.equals("yes") || response.equals("") ) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        ArrayList<Score> list = new ArrayList<>();
        Scanner keyScan = new Scanner(System.in);
        Score score;
        while(true) {
            System.out.print("성적관리> ");
            String input = keyScan.nextLine();


            if (input.equals("add")) {
                score = new Score();
                while(true) {
                    score = new Score();
                    score.input();
                    list.add(score);

                    if (!confirm("계속 하시겠습니까?")) break; }
            }

            if (input.equals("list")) {
                Iterator<Score> iterator = list.iterator();
                while(iterator.hasNext())
                {
                    iterator.next().list();
                }

            }

            if (input.equals("view")) {
                System.out.print("이름? ");
                String name = keyScan.nextLine();
                for (int i = 0; i < list.size(); i++) {

                    if (name.equals(list.get(i).name)) {
                        list.get(i).print();
                        break;
                    }


                }
                
            }

            if (input.equals("delete")) {
                System.out.print("이름? ");
                String name = keyScan.nextLine();

                if(confirm("정말 삭제 하시겠습니까?(y/N) ")) {

                    for (int i = 0; i < list.size(); i++) {

                        if (name.equals(list.get(i).name)) {
                            list.remove(i);
                            System.out.println("삭제 하였습니다.");
                            break;
                        }
                    }

                }
                else System.out.println("삭제취소하였습니다.");
            }

            
            if (input.equals("update")) {
                System.out.print("이름? ");
                String name = keyScan.nextLine();

                for (int i = 0; i < list.size(); i++) {

                    if (name.equals(list.get(i).name)) {
                        System.out.printf("국어?(%d) ", list.get(i).subjects[0]);
                        int kor = keyScan.nextInt();
                        System.out.printf("영어?(%d) ", list.get(i).subjects[1]);
                        int eng = keyScan.nextInt();
                        System.out.printf("수학?(%d) ", list.get(i).subjects[2]);
                        int math = keyScan.nextInt();

                        if(confirm("변경하시겠습니까(n/Y) ")) {
                            list.get(i).subjects[0] = kor;
                            list.get(i).subjects[1] = eng;
                            list.get(i).subjects[2] = math;
                            System.out.println("변경하였습니다.");
                        }else {
                            System.out.println("취소하였습니다.");
                            break;
                        }

                    }
                }
                
               

            }
            System.out.println();
        }



    }

}









