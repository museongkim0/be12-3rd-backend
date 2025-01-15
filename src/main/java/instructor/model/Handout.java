package instructor.model;

import java.io.File;
import java.util.List;

public class Handout {
    private int idx;
    private String title;
    private String content;
    private File file;
    private String writer;

    public Handout(){}

    public Handout(String title, String content, File file, String writer) {
        this.title = title;
        this.content = content;
        this.file = file;
        this.writer = writer;
    }

    public Handout(int idx, String title, String content, File file, String writer) {
        this.idx = idx;
        this.title = title;
        this.content = content;
        this.file = file;
        this.writer = writer;
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

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
