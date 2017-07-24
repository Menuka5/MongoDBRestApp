package hsenid.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by Kasun Dinesh on 08-Jul-17.
 */

@JsonPropertyOrder({"status", "code", "errorMessage", "description"})
public class ErrorMessage {
    private String status; // State of the request
    private String errorCode; // HTTP status code
    private String errorMessage; // Error message returned
    private String description; // Error description

    public ErrorMessage() {
    }

    public ErrorMessage(String status, String errorCode, String errorMessage, String description) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.description = description;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("code")
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @JsonProperty("errorMessage")
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

