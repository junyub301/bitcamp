package bitcamp.java100.ch14.ex1;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

public class Test11 {


    public static void main(String[] args) throws Exception {


        File file = new File(".");
        printFiles(file);
    }

    static void printFiles(File dir) throws Exception {
        File[] files = dir.listFiles();

        for(File f : files) {
            if (f.isFile() && f.getName().endsWith(".class")) {
                System.out.println(f.getName());
            }
            if (f.isDirectory()) {
                printFiles(f);
            }
        }
    }

}

//File[] filenames = file.listFiles(new FileFilter() {
//    @Override
//    public boolean accept(File pathname) {
//        
//        if (pathname.getName().startsWith("."))
//            return false;
//        else
//            return true;
//    }
//
//});
