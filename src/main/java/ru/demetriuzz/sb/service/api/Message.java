package ru.demetriuzz.sb.service.api;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Output Message For Controller
 */
public class Message {

    private final String text;
    private final LocalDateTime dateTime;
    private final Long ts;

    public Message() {
        this(null);
    }

    public Message(String text) {
        this.text = text;
        this.dateTime = LocalDateTime.now();
        this.ts = dateTime.toEpochSecond(ZoneOffset.UTC);
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Long getTs() {
        return ts;
    }

}
