package bitcamp.java100.ch04;

public class Test18_6 {
      
   
    public static void main(String[] args) throws Exception {
        String email = "hong@test.com";
        
        // matches(정규표현식) : 정규표현식(Regular Expression)의 규칙과 맞는지 검사. -> true/false
        System.out.println(email.matches("1hong@test.com"));
        // . : 임의의 문자 한개
        // +(한 개 이상), *(0개이상), ?(0 또는 한 개) 
        // \. : 그냥 dot 문자
        System.out.println(email.matches(".+@.+\\..+"));
        // \D : 숫자를 제외한 문자
        System.out.println(email.matches("^\\D.+@.+\\..+"));
        
        // java.util.regex.Pattern 클래스의 API 문서 참조
        System.out.println("-------------------------------------------");
        
        String str = "홍길동(hong@test.com),임꺽정(leem@test.com)," +
                    "유관순(yoo@test.com),안중근(ahn@test.com),윤봉길(yoon@test.com)";
        
        // 해당 문자열에서 주어진 규칙을 갖는 문자열을 찾아 출력하기
        // => 정규표현식 규칙을 생성
        java.util.regex.Pattern pattern = 
                java.util.regex.Pattern.compile("\\w+@\\w+\\.\\w+");
        // 정규표현식 규칙에 따라 검사를 수행할 객체를 준비
        java.util.regex.Matcher matcher = pattern.matcher(str);
        
        //Matcher를 이용하여 규칙에 해당하는 문자열을 찾는다
        int startIndex = 0;
        while (matcher.find(startIndex)) {
            System.out.println(startIndex);
            String matchString = matcher.group();
            startIndex = matcher.end();
            System.out.println(matchString);
            
        }
        
        
        
        
    }
}