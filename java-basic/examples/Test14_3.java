package bitcamp.java100;

public class Test14_3 {
      
    public static void main(String[] args){

        class Student {
            String name;
            String address;
            String phone;
            String major;
            char sex;
            int age;

        }
        
        Student sd = new Student();
        sd.name = "홍길동";
        sd.address = "서울 어딘가";
        sd.phone = "010-1234-5678";
        sd.major = "컴퓨터";
        sd.sex = '남';
        sd.age = 25;

        System.out.printf("이름: %s\n주소: %s\n전화번호: %s\n전공: %s\n성별: %c\n나이: %d\n", sd.name, sd.address, sd.phone, sd.major, sd.sex, sd.age);
        
    }

}