package bitcamp.java100;

public class Test15_12_1 {
      
    public static void main(String[] args){
        
        // 파일의 정보를 저장
        // 디렉토리여부, 소유주/그룹/기타 사용자의 읽기, 쓰기, 권한 정보
        

        // int 메모리와 비트 연산자 이용
        
        int p1 =0;
        p1 = 0b0_111_101_101;
        
        final int DIRECTORY     = 0x0200; //0b0010_0000_0000;
        final int OWNER_READ    = 0x0100; //0b0001_0000_0000;
        final int OWNER_WRITE   = 0x0080; //0b0000_1000_0000;
        final int OWNER_EXE     = 0x0040; //0b0000_0100_0000;
        final int GROUP_READ    = 0x0020; //0b0000_0010_0000;
        final int GROUP_WRITE   = 0x0010; //0b0000_0001_0000;
        final int GROUP_EXE     = 0x0008; //0b0000_0000_1000;
        final int OTHER_READ    = 0x0004; //0b0000_0000_0100;
        final int OTHER_WRITE   = 0x0002; //0b0000_0000_0010;
        final int OTHER_EXE     = 0x0001; //0b0000_0000_0001;
        
        
        System.out.print((p1 & DIRECTORY) == DIRECTORY ? "d" : "-");
        System.out.print((p1 & OWNER_READ) == OWNER_READ ? "r" : "-");
        System.out.print((p1 & OWNER_WRITE) == OWNER_WRITE ? "w" : "-");
        System.out.print((p1 & OWNER_EXE) == OWNER_EXE ? "x" : "-");
        System.out.print((p1 & GROUP_READ) == GROUP_READ ? "r" : "-");
        System.out.print((p1 & GROUP_WRITE) == GROUP_WRITE ? "w" : "-");
        System.out.print((p1 & GROUP_EXE) == GROUP_EXE ? "x" : "-");
        System.out.print((p1 & OTHER_READ) == OTHER_READ ? "r" : "-");
        System.out.print((p1 & OTHER_WRITE) == OTHER_WRITE ? "w" : "-");
        System.out.print((p1 & OTHER_EXE) == OTHER_EXE ? "x" : "-");
        System.out.println("");
        
    }

}

