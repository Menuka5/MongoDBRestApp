package hsenid.domain;

/**
 * Created by Kasun Dinesh on 08-Jul-17.
 */
public class Link {
    private String link; // HATEOAS link (URL)
    private String rel; // Description

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }
}
