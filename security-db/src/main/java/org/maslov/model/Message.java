package org.maslov.model;


public class Message {
    private String author;
    private String text;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Message(String author, String text) {
        this.author = author;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
