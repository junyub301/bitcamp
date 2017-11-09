package java100.app.control;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import java100.app.domain.Room;
import java100.app.domain.Score;
import java100.app.util.Prompts;

public class RoomController extends ArrayList<Room> implements Controller {

    private String dataFilePath;
    Scanner keyScan = new Scanner(System.in);

    public RoomController(String dataFilePath) {
        this.dataFilePath = dataFilePath;
        this.init();
    }

    @Override
    public void destroy() {
        try(FileWriter out = new FileWriter(this.dataFilePath);) {
            for (Room room : this) {
                out.write(room.toCSVString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        try (FileReader in = new FileReader(this.dataFilePath);
                Scanner lineScan = new Scanner(in);) {
            String csv = null;
            while(lineScan.hasNextLine()) {
                csv = lineScan.nextLine();
                try {
                    this.add(new Room(csv));
                } catch (CSVFormatException e) {
                    System.err.println("CSV 데이터 형식 오류!");
                    e.printStackTrace();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void execute() {
        loop:
            while(true) {
                System.out.print("강의실관리> ");
                String input = keyScan.nextLine();

                switch (input) {
                case "add": this.doAdd(); break;
                case "list": this.doList(); break;
                case "delete": this.doDelete(); break;
                case "main":; break loop;
                default:
                    System.out.println("해당 명령이 없습니다.");
                }

                System.out.println();
            } // while        
    }

    private void doList() {

        System.out.println("[강의실 목록]");
        Iterator<Room> iterator = this.iterator();
        while (iterator.hasNext()) {
            Room room = iterator.next();
            System.out.printf("%s, %s, %d\n",  
                    room.getLocation(), 
                    room.getName(),
                    room.getCapacity());
        }

    }

    private void doAdd() {

        System.out.println("[강의실 등록]");

        Room room = new Room();;
        room.setName(Prompts.inputString("강의실 이름? "));

        if (find(room.getName()) != null) {
            System.out.println("이미 등록된 강의실 입니다");
            return;
        } 
        room.setLocation(Prompts.inputString("지역? "));
        room.setCapacity(Prompts.inputInt("수용인원? "));

        this.add(room);
    }

    private void doDelete() {
        System.out.println("[강의실 삭제]");
        String roomName = Prompts.inputString("강의실 이름? ");

        Room room = find(roomName);

        if (room == null) {
            System.out.printf("'%s'의 강의실 정보가 없습니다.\n", roomName);
            return;
        } 
        if (Prompts.confirm2("정말 삭제하겠습니까?(y/N)")) {
            this.remove(room);
            System.out.println("삭제했습니다.");
        } else System.out.println("삭제 취소했습니다.");

    }

    private Room find(String roomName) {
        Iterator<Room> iterator = this.iterator();

        while (iterator.hasNext()) {
            Room room = iterator.next();
            if(room.getName().equals(roomName)) {
                return room;
            }
        }//while
        return null;
    }




}
