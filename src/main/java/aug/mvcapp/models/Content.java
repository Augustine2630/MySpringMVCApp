package aug.mvcapp.models;

public class Content {
    private int id;
    private String contentName;
    private String info;

    public Content() {
    }

    public Content(int id, String contentName, String info) {
        this.id = id;
        this.contentName = contentName;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
