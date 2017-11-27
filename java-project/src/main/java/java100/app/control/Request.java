package java100.app.control;

import java.net.URLDecoder;
import java.util.HashMap;

public class Request {
    private String menuPath;
    private HashMap<String, String> params = new HashMap<>();
    

    public Request(String command) {
        String[] path = command.split("\\?");

        this.menuPath = path[0];

        if (path.length > 1) {
            String[] arr = path[1].split("&");
            for (String param : arr) {
                String[] kv = param.split("=");
                try {
                    
                    params.put(kv[0], URLDecoder.decode(kv[1], "UTF-8")); 
                    // UTF-8을 URL인코딩 한것이다 그러므로 URL디코딩을 해줘야 된다.
                    // 이것을 하지 않으면 웹에서 add한 한글이 깨진다.
                    
                    
                    
                } catch (Exception e) {}
            }
        }
    }

    public String getMenuPath() {
        return this.menuPath;
    }

    public String getParameter(String name) {
        return this.params.get(name);
    }


}
