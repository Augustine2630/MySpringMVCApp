package aug.mvcapp.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Content {


    private int id;

    @NotEmpty(message = "Empty name!")
    @Size(min=2, max=40, message = "Name should be between 2 and 30 characters")
    private String contentName;

    @NotEmpty(message = "Email should not be empty")
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
