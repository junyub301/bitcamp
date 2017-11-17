package bitcamp.java100.ch15.ex6;

import java.util.Properties;
import java.util.Set;

public class Test1 {

    public static void main(String[] args) {
        
        
        System.out.println("------------------------------------------------");
        for (String value : args) {
            System.out.println(value);
        }
        
        System.out.println("------------------------------------------------");
        System.out.println(System.getProperty("aaa"));
        System.out.println(System.getProperty("bbb"));
        
        System.out.println("------------------------------------------------");
        Properties props = System.getProperties();
        Set<Object> keySet = props.keySet();
        for (Object key: keySet) {
            System.out.printf("%s=%s\n", key, props.get(key));
        }
    }
}
