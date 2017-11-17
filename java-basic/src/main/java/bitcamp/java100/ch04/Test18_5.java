package bitcamp.java100;


public class Test18_5 {
      
   
    public static void main(String[] args) throws Exception {
        String s1 = "ABC가각간";
        
        String s2 = s1.replace("BC", "하하하");
        
        System.out.println(s1);
        System.out.println(s2);
        
        System.out.println(s1.charAt(4));
        
        s1 = "ABBCDEBBFGH";

        // indexOf(찾을 문자열) : 앞에서부터 문자열을 찾는다.
        System.out.println(s1.indexOf("BB"));
        
        // LastIndexOf(찾을 문자열) : 뒤에서부터 찾는다.
        System.out.println(s1.lastIndexOf("BB"));
        
        // substring(추출한 문자열의 시작 인덱스) : 지정된 인덱스의 문자부터 끝까지 문자열 추출
        System.out.println(s1.substring(3));
        
        // substring(추출한 문자열의 시작 인덱스,끝 인덱스) : 시작 인덱스부터 끝 인덱스바로 직전까지 문자열 추출
        System.out.println(s1.substring(3, 6));
        
        s1 = "홍길동";
        
        // startsWith(시작문자열) : 주어진 문자열로 시작하는지 검사 -> true/false
        System.out.println(s1.startsWith("홍길"));
        System.out.println(s1.startsWith("길"));
        
        // endsWith(끝문자열) : 해당 문자열이 주어진 문자열로 끝나는지 검사 -> true/false
        System.out.println(s1.endsWith("동"));
        System.out.println(s1.endsWith("원"));
        
        s1 = "홍길동,유관순,임꺽정,안중근,윤봉길,이육사,윤동주";
        
        // contains(포함문자열) : 해당 문자열에 주어진 문자열이 있는지 검사
        System.out.println(s1.contains("꺽정"));
        System.out.println(s1.contains("김꺽정"));
        
        String s3 = "ABC";
        String s4 = "가각간";
        
        // concat(추가할 문자열) : 해당 문자열에 주어진 문자열을 추가하여 새 String 인스턴스를 만든다.
        System.out.println(s3.concat(s4));
        System.out.println(s3);
        System.out.println(s4);
        
        s3 = new String("탕수육");
        s4 = new String("탕수육2");
        String s5 = new String("탈수육");
        String s6 = new String("탕수육");
        
        // 문자열1.compareTo(문자열.2) : 두 문자열을 비교하여 같으면 0을 리턴
        // 알파벳/가나다 순서에서 문자열1이 문자열2보다 앞서면 음수, 뒤면 양수 리턴
        System.out.println(s3.compareTo(s6));
        System.out.println(s3.compareTo(s4));
        System.out.println(s3.compareTo(s5));
        
        s1 = "홍길동";
        s2 = "";
        s3 = null;
        // isEmpty() : String 인스턴스에 저장된 문자열이 비어 있는지 검사한다.
        System.out.println(s1.isEmpty());
        System.out.println(s2.isEmpty());
        // System.out.println(s3.isEmpty()); -> 인스턴스가 없으면 실행 오류 
        
        // length() : String 인스턴스에 저장된 문자의 개수를 리턴한다.
        System.out.println(s1.length());
        System.out.println(s2.length());
        // System.out.println(s3.length()); -> 실행오류
        
        s1 = "홍길동,유관순,임꺽정,안중근,윤봉길,이육사,윤동주";
        // split(구분자) : 해당문자열을 구분자로 분리하여 String[] 배열을 만들어 리턴한다.
        String[] arr = s1.split(",");
        for (String s : arr) {
            System.out.print(s);
            System.out.print("-");
        }
        System.out.println();
    
        // 해당문자열에 구분자가 없으면 그 문자열을 그대로 배열에 담아 리턴한다.
        arr = s1.split(" ");
        System.out.println(arr.length);
        System.out.println(arr[0]);

        // 빈문자열도 문자열이기 때문에 배열로 리턴된다.
        s1 = "";
        
        arr = s1.split(",");
        System.out.println(arr.length);
        System.out.println(arr[0]);
        
        s1 = "Hong Gil Dong";
        
        // toLowerCase() : 해당 문자열을 모두 소문자로 바꾼 새 String (객체)을 만든 후 그 객체(의 주소)를 리턴
        System.out.println(s1.toLowerCase());
        // toUpperCase() : 해당 문자열을 모두 대문자로 바꾼 새 String (객체)을 만든 후 그 객체(의 주소)를 리턴
        System.out.println(s1.toUpperCase());
    
        s1 = "  \t홍\t길동 \n입니다.\n\n\n\t\n";
        
        // trim() : 해당 문자열 양쪽의 공백(white space)을 제거
        System.out.print(">");
        System.out.print(s1.trim());
        System.out.println("<");
        
        s1 = "ABC\n가각간\n똘똥똥";
        
        // getBytes() : 해당 문자열을 바이트 배열로 만들어 리턴한다. 
        // 바이트 배열에 저장되는 값은 JVM에 설정된 문자집합의 코드 값이다. 
        byte[] bytes = s1.getBytes();
        for (byte b : bytes) {
            System.out.print(Integer.toHexString(b & 0x00ff));
            System.out.print(" ");
        }
        System.out.println();
        
        // getBytes(문자집합) : 가능한 문자 집합을 명시하여 바이트 배열을 만들어라. -> os에 상관없이 동일한 결과.
        bytes = s1.getBytes("UTF-8");
        for (byte b : bytes) {
            System.out.print(Integer.toHexString(b & 0x00ff));
            System.out.print(" ");
        }
        System.out.println();
        
        // valuOf(값) : 주어진 값을 가지고 String 인스턴스를 생성하는 메서드
        s1 = String.valueOf(true);
        s2 = String.valueOf(3.14);
        s3 = String.valueOf(100);
        
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        
        s1 = "ABC";
        s2 = "가각간";
        s3 = s1 + s2;
        
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    
    }
}