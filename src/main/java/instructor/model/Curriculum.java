package instructor.model;

import java.io.File;
import java.util.List;

public class Curriculum {
    private int idx;
    private String title;
    private String content;

    public Curriculum(){}

    public Curriculum(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Curriculum(int idx, String title, String content) {
        this.idx = idx;
        this.title = title;
        this.content = content;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
