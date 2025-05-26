package im_common;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message implements Serializable {
    private String sender;
    private String receiver;
    private String timestamp;
    private String content;
    private String messageType;
    private static final long serialVersion = 1l;
    private byte[] file;
    private String targetPath;

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getTargetPath() {
        return targetPath;
    }

    public void setTargetPath(String targetPath) {
        this.targetPath = targetPath;
    }

    public Message(String sender, String receiver, String content, String messageType) {
        this.sender = sender;
        this.receiver = receiver;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
        this.timestamp = LocalDateTime.now().format(formatter);
        this.content = content;
        this.messageType = messageType;
    }

    public Message() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
        this.timestamp = LocalDateTime.now().format(formatter);
    }

    public Message(String receiver, byte[] data, String targetPath, String msgType) {
        this.file = data;
        this.targetPath = targetPath;
        this.receiver = receiver;
        this.messageType = msgType;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
        this.timestamp = LocalDateTime.now().format(formatter);
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
