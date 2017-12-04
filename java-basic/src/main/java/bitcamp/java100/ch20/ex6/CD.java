package bitcamp.java100.ch20.ex6;

public class CD {
    private String title;
    private String Singer;
    
    public CD() {
        System.out.println("CD()");
    }

    @Override
    public String toString() {
        return "CD [title=" + title + ", Singer=" + Singer + "]";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return Singer;
    }

    public void setSinger(String singer) {
        Singer = singer;
    }
    
    
}
