package java100.app;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

import java100.app.control.BoardController;
import java100.app.control.Controller;
import java100.app.control.MemberController;
import java100.app.control.Request;
import java100.app.control.Response;
import java100.app.control.RoomController;
import java100.app.control.ScoreController;

//01026344150
//jinyoun.eom@gmail.com

public class App {
    ServerSocket ss;
    static HashMap<String,Controller> controllerMap = new HashMap<>();
    static Scanner keyScan = new Scanner(System.in);

    void init() {
        ScoreController scoreController = new ScoreController();
        scoreController.init();
        controllerMap.put("/score", scoreController);

        MemberController memberController = new MemberController();
        memberController.init();
        controllerMap.put("/member", memberController);

        BoardController boardController = new BoardController();
        boardController.init();
        controllerMap.put("/board",boardController);
        
        RoomController roomController = new RoomController();
        roomController.init();
       controllerMap.put("/room",roomController);
    
        



    }

    void  service() throws Exception {
        ss = new ServerSocket(9999);
        System.out.println("서버 시작!");

        while(true) {
            new HttpAgent(ss.accept()).start();
        } // while

        // 모든 컨트롤러에 대해 마무리 작업을 지시한다.
    }

    private void save() {
        Collection<Controller> controllers = controllerMap.values();
        for (Controller controller : controllers) {
            controller.destroy();
        }


    }

    private void request(String command, PrintWriter out) {

        String menuName = command;
        int i = command.indexOf("/", 1); // index번호가 1번부터 "/"가 나올때 까지 찾는다.

        if (i != -1) {
            menuName = command.substring(0,i);// 0부터 i전까지 출력
        }

        Controller controller = controllerMap.get(menuName);

        if (controller == null) {
            out.println("해당 명령을 지원하지 않습니다.");
            return;
        }

        Request request = new Request(command);

        Response response = new Response();
        response.setWriter(out);

        controller.execute(request, response);
        //                controller.execute();

    }

    private void hello(String command, PrintWriter out) {
        out.println("안녕하세요. 성적관리 시스템입니다.");
        out.println("[성적관리 명령들]");
        out.println("목록보기: /score/list");
        out.println("상세보기: /score/view?name=이름");
        out.println("등록: /score/add?name=이름&kor=점수&eng=점수&math=점수");
        out.println("변경: /score/update?name=이름&kor=점수&eng=점수&math=점수");
        out.println("삭제: /score/delete?name=이름");
        out.println("[회원]");
        out.println("[게시판]");
        out.println("[강의실]");
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.init();
        app.service();

    }

    class HttpAgent extends Thread {

        Socket socket;
        public HttpAgent(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
                try(
                        Socket socket = this.socket; 
                        BufferedReader in = new BufferedReader(
                                new InputStreamReader(socket.getInputStream()));

                        PrintWriter out = new PrintWriter(
                                new BufferedOutputStream(socket.getOutputStream()));
                        ) {

                    String command = in.readLine().split(" ")[1];
                    
                    String header = null;
                    while (true) {
                        header = in.readLine();
                        if (header.equals(""))
                            break;
                    }
                    
                    out.println("HTTP/1.1 200 OK");
                    
                    out.println("Content-Type:text/plain;charset=UTF-8");
                    
                    out.println();
                    
                    if (command.equals("/")) {
                        hello(command, out);
                    } else {
                        request(command, out);
                        save();
                    }
                    out.println(); // 응답 완료를 표시하기 위해 빈줄을 보낸다.
                    out.flush();

                }catch (Exception e) {
                    e.printStackTrace();
                }
        }        
    }

}






