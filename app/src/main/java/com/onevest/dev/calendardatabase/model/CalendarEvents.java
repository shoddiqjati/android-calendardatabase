package com.onevest.dev.calendardatabase.model;

public class CalendarEvents {

    private int eventId;
    private String eventTitle;
    private long eventStartTime;
    private long eventEndTime;

    public CalendarEvents(int eventId, String eventTitle, long eventStartTime, long eventEndTime) {
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

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
