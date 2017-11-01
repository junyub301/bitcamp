package bitcamp.java100.ch09.ex6;

public class ScoreStack {
    
    private class Box {
        Score value;
        Box next;
        
        public Box() {}
        
        public Box(Score value) {
            this.value = value;
        }
        
    }
    
    Box top;

    int len;

    public void push(Score value) {
        
        Box box = new Box(value);

        box.next = top;
        
        top = box;
        
        len++;
    }

    public int size() {
        return len;
    }

    public Score pop() {
        if (len == 0)
            return null;
        
        Box box = top;
        top = top.next;
        
        len--;

        return box.value;
    }

    

}
