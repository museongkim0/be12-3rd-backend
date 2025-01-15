package instructor.model;

import java.io.File;
import java.util.List;

public class Homework {
    private int idx;
    private String title;
    private String content;
    private File file;
    private String writer;
    private List<String> solved;

    public Homework(){}

    public Homework(String title, String content, File file, String writer) {
        this.title = title;
        this.content = content;
        this.file = file;
        this.writer = writer;
    }

    public Homework(int idx, String title, String content, File file, String writer, List<String> solved) {
        this.idx = idx;
        this.title = title;
        this.content = content;
        this.file = file;
        this.writer = writer;
        this.solved = solved;
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

    public List<String> getSolved() {
        return solved;
    }

    public void setSolved(List<String> solved) {
        this.solved = solved;
    }
}
