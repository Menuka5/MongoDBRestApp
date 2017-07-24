package hsenid.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kasun Dinesh on 08-Jul-17.
 */
@JsonPropertyOrder({"status", "code", "message", "data", "links"})
public class SuccessMessage {
    private String status; // State of the request
    private int code; // State of the request
    private String message; // HTTP status code
    private List<JSONObject> data = new ArrayList<JSONObject>(); // Resources to include in the response
    private List<Link> links = new ArrayList<Link>(); // HATEOAS links

    public SuccessMessage() {
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("code")
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("links")
    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @JsonProperty("data")
    public List<JSONObject> getData() {
        return data;
    }

    public void setData(List<JSONObject> data) {
        this.data = data;
    }

    // Add HATEOAS links
    public void addLink(String url, String rel) {
        Link link = new Link();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
    }

    // Add data(resources) to represent
    public void addData(JSONObject jsonObject) {
        data.add(jsonObject);
    }

    // Optionally we can call this method to generate the JSON response.
    // Order not preserved.
    public JSONObject generateSuccessMessage() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", getStatus());
        jsonObject.put("code", getCode());
        jsonObject.put("message", getMessage());
        jsonObject.put("data", getData());
        jsonObject.put("links", getLinks());
        return jsonObject;
    }
}
