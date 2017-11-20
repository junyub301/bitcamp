package java100.app.control.copy;

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
                params.put(kv[0], kv[1]);
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
