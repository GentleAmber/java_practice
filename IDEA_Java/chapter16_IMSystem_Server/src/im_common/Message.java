package im_common;

import java.io.Serializable;

public class Message implements Serializable {
    private String sender;
    private String receiver;
    private String timestamp;
    private String content;
    private String messageType;
    private static final long serialVersion = 1l;

    public Message(String sender, String receiver, String timestamp, String content, String messageType) {
        this.sender = sender;
        this.receiver = receiver;
        this.timestamp = timestamp;
        this.content = content;
        this.messageType = messageType;
    }

    public Message() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
