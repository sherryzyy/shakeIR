package core;

public class webResult {
    private String title;
    private String content;
    private String url;


    public webResult(String title, String content, String url) {
        this.title = title;
        this.content = content;
        this.url = url;

    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }


}
