package bitcamp.java100.ch02;

public class Test16_2 {
      
    public static void main(String[] args){

        int age = 17;
        
        if (age < 20)
            System.out.println("미성년");
        else
            System.out.println("성인");
        
        age = 67;
        if (age > 65)
            System.out.println("경로우대 대상자입니다.");
        
        System.out.println("------------------------------");
        age = 27;
        if (age <= 19)  
            System.out.println("미성년");
            System.out.println("청소년 할인을 받을 수 있습니다.");
            
        System.out.println("------------------------------");
        age = 27;
        if (age <= 19) {  
            System.out.println("미성년");
            System.out.println("청소년 할인을 받을 수 있습니다.");
        }
        
        age = 13;
 
        if ( age <= 19) 
            if ( age > 13)
                System.out.println("청소년");
        
        age = 27;
        if (age < 19) 
            if(age > 13)
                System.out.println("청소년");
        else
            System.out.println("성년");
        
        System.out.println("------------------------------");
        
        age = 27;
        if (age < 19) {
            if(age > 13)
                System.out.println("청소년"); }
            else
                System.out.println("성년");
        
        System.out.println("------------------------------");
        
        age = 13;
        if (age < 19) 
            if(age > 13)
                System.out.println("청소년"); 
            else 
                System.out.println("어린이 또는 유아");
        
        
        System.out.println("------------------------------");
        
        age = 14;
        if (age <= 19) 
            if(age > 13)
                System.out.println("청소년"); 
            else 
                System.out.println("어린이 또는 유아");
            else
                System.out.println("성년입니다.");

        System.out.println("------------------------------");
        
        age = 65;
        if (age <= 19) 
            if(age > 13)
                System.out.println("청소년"); 
            else 
                System.out.println("어린이 또는 유아");
        else
           if (age < 65)
               System.out.println("성년입니다.");
           else
               System.out.println("노인입니다.");
        
        System.out.println("------------------------------");
        
        age = 65;
        if (age <= 19) { 
            if(age > 13)
                System.out.println("청소년"); 
            else 
                System.out.println("어린이 또는 유아"); 
        }
        else {
            if (age < 65)
                System.out.println("성년입니다.");
            else
                System.out.println("노인입니다."); 
        }
        
        System.out.println("------------------------------");
        
        age = 72;
        if (age < 8)
            System.out.println("유아");
        else 
            if (age < 14)
                System.out.println("어린이");
            else
                if (age < 20)
                    System.out.println("청소년");
                else
                    if (age < 65)
                        System.out.println("성년");
                    else 
                        System.out.println("노인");
        
        System.out.println("------------------------------");
        
        age = 72;
        if (age < 8)
            System.out.println("유아");
        else if (age < 14)
            System.out.println("어린이");
        else if (age < 20)
            System.out.println("청소년");
        else if (age < 65)
             System.out.println("성년");
        else 
             System.out.println("노인");
        
        System.out.println("------------------------------");
        
        age = 72;
        if (age < 8) {
            System.out.println("유아");
        } else if (age < 14) {
            System.out.println("어린이");
        } else if (age < 20) {
            System.out.println("청소년");
        } else if (age < 65) {
            System.out.println("성년");
        } else { 
            System.out.println("노인");
        }
    }
}
