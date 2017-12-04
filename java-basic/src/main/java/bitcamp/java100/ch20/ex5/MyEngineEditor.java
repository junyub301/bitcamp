package bitcamp.java100.ch20.ex5;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

public class MyEngineEditor extends PropertyEditorSupport{

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] values = text.split(",");
        
        Engine engine = new Engine();
        engine.setName(values[0]);
        engine.setValve(Integer.parseInt(values[1]));
        engine.setCc(Integer.parseInt(values[2]));
        this.setValue(engine);
        
    }
    
    

}
