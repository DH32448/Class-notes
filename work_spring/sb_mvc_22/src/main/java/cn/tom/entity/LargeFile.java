package cn.tom.entity;

public class LargeFile {
    private String id;
    private String filename;
    private Object content; //文件内容  -->longblob

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "LargeFile{" +
                "id='" + id + '\'' +
                ", filename='" + filename + '\'' +
                ", content=" + content +
                '}';
    }
}
