package src.core;

import java.net.URI;

public class Documents {
    private Integer docID;
    private String name;
    private URI uri;
    private String content;

    public Integer getDocID() {
        return docID;
    }

    public void setDocID(Integer docID) {
        this.docID = docID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
