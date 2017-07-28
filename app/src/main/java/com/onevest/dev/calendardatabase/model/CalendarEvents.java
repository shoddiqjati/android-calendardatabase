package com.onevest.dev.calendardatabase.model;

public class CalendarEvents {
    private String eventTitle;
    private long eventStartTime;
    private long eventEndTime;

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public long getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(long eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public long getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(long eventEndTime) {
        this.eventEndTime = eventEndTime;
    }
}
