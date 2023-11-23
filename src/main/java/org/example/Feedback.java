package org.example;

public class Feedback {
    private String message;
    private Visitor v;

    public Feedback(String message, Visitor v) {
        this.message = message;
        this.v = v;
    }

    public String getMessage() {
        return message;
    }

    public Visitor getV() {
        return v;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setV(Visitor v) {
        this.v = v;
    }
}
