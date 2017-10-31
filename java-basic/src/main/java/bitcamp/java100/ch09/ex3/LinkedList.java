package bitcamp.java100.ch09.ex3;

public class LinkedList {
    
    private class Box {
        Object value;
        Box next;
    }
    
    Box head;
    Box tail;

    int len;


    public void add(Object value) {
        Box box = new Box();

        box.value = value;

        if (tail == null) {
            head = box;
            tail = box;
        } else {
            tail.next = box;
            tail = box;
        }

        len++;
    }

    public int size() {
        return len;
    }

    public Object get(int index) {
        if (index < 0 || index >= len) 
            return null;

        Box box = head;
        for (int count = 1; count <= index; count++) {
            box = box.next;
        }

        return box.value;
    }

    public void insert(int index, Object value) {
        if (index < 0 || index >= len) 
            return;
        Box box = head;
        Box box2 = new Box();
        box2.value = value;

        len++;

        if (index == 0) {
            box2.next = head;
            head = box2;
            return;
        }else {
            for (int i = 0; i < index -1; i++) 
                box = box.next;
            box2.next = box.next;
            box.next = box2;
        }

    }

    public Object remove(int index) {
        if (index < 0 || index >= len) 
            return null;
        Box del;
        len--;
        
        if (index == 0) {
            del = head;
            head = head.next;
            return del.value;
        }
        Box box = head;

        for (int i = 0; i < index - 1; i++)
            box = box.next;
        del = box.next;
        box.next = box.next.next;

        if (index == len - 1) {
            tail = box;
        }

        return del.value;
    }

}
