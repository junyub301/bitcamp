package java100.app.control.copy;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class GenericController<T> implements Controller {
    static Scanner keyScan = new Scanner(System.in);
    protected ArrayList<T> list = new ArrayList<>();
   

    //Contorller 인터페이스로부터 execute()라는 수창 메서드륻 물려받았기 때문에 여기서 선언하면 안된다.
//    public abstract void execute();
}
