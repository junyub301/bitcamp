package bitcamp.java100.ch09.ex1;

public class Test2 {

    public static void main(String[] args) {
        Array list = new Array();
        
        
        list.add(new String("홍길동"));
        list.add(new Integer(100));
        list.add(80);
        list.add(70);
        list.add(250);
        list.add(250 / 3f);
        list.add("임꺽정");
        list.add(80);
        list.add(80); 
        list.add(80);
        list.add(240);
        list.add(240 / 3f);
        
        for (int i = 0; i < list.size(); i++)
        {
            System.out.printf("%d : %s\n", i, list.get(i));
        }
        
        System.out.println("-----------------------------------------");
        
        list.insert(6, "유관순");

        for (int i = 0; i < list.size(); i++)
        {
            System.out.printf("%d : %s\n", i, list.get(i));
        }
        System.out.println("-----------------------------------------");
        
        System.out.println(list.remove(11));
        System.out.println(list.remove(10));
        for (int i = 0; i < list.size(); i++)
        {
            System.out.printf("%d : %s\n", i, list.get(i));
        }
        
    }

}
