package bitcamp.java100;

public class Test14_2 {
      
    public static void main(String[] args){

        class Book {

            String name;
            String ath;
            String sto;
            int page;
            double cost;
        }
        
        Book b1 = new Book();
        b1.name = "정보처리기사";
        b1.ath = "한기준";
        b1.sto = "시나공";
        b1.page = 480;
        b1.cost = 26.97;
        
        System.out.printf("%s %s %s %d %f\n", b1.name, b1.ath, b1.sto, b1.page, b1.cost);

        
    }

}