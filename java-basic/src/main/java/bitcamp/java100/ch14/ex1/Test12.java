package bitcamp.java100.ch14.ex1;

import java.io.File;

public class Test12 {


    public static void main(String[] args) throws Exception {


        File file = new File(".");
        printFiles(file);
    }

    static void printFiles(File dir) throws Exception {
        File[] files = dir.listFiles();
        String path;
        int i = 0;
        for(File f : files) {
            if (f.isFile() && f.getName().endsWith(".class")) {
                path = f.getCanonicalPath();
                i = path.indexOf("bin") + 4;
                System.out.println(path.substring(i)
                        .replace(".class", "")
                        .replace("\\", "."));
                
                        
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
