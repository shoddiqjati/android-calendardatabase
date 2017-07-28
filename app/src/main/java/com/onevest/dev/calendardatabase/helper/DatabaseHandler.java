package com.onevest.dev.calendardatabase.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.onevest.dev.calendardatabase.model.CalendarEvents;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "calendarDatabase";
    private static final String TB_NAME = "tb_events";

    private static final String EVENT_ID = "event_id";
    private static final String EVENT_TITLE = "event_title";
    private static final String EVENT_START = "event_start";
    private static final String EVENT_END = "event_end";

    public DatabaseHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_EVENTS_TABLE = "CREATE TABLE " +
                TB_NAME + "(" + EVENT_ID + " INTEGER PRIMARY KEY,"+
                EVENT_TITLE + " TEXT," +
                EVENT_START + " INTEGER," +
                EVENT_END + " INTEGER" + ")";
        sqLiteDatabase.execSQL(CREATE_EVENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP IF TABLE EXIST " + TB_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addEvent(CalendarEvents events) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(EVENT_ID, events.getEventId());
        values.put(EVENT_TITLE, events.getEventTitle());
        values.put(EVENT_START, events.getEventStartTime());
        values.put(EVENT_END, events.getEventEndTime());

        db.insert(TB_NAME, null, values);
        db.close();
    }

    public CalendarEvents getEvent(int id) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TB_NAME, new String[] {EVENT_ID, EVENT_TITLE, EVENT_START, EVENT_END},
                EVENT_ID + "=?", new String[] {String.valueOf(id)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        CalendarEvents event = new CalendarEvents(cursor.getInt(0),
                cursor.getString(1),
                cursor.getLong(2),
                cursor.getLong(3));
        cursor.close();
        return event;
    }

    public List<CalendarEvents> getAllEvents() {
        List<CalendarEvents> list = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TB_NAME;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        while (cursor.moveToNext()) {
            CalendarEvents event = new CalendarEvents();
            event.setEventId(cursor.getInt(0));
            event.setEventTitle(cursor.getString(1));
            event.setEventStartTime(cursor.getLong(2));
            event.setEventEndTime(cursor.getLong(3));
            list.add(event);
        }

        cursor.close();

        return list;
    }

    public int getEventsCount() {
        return 0;
    }

    public int updateEvent(CalendarEvents events) {
        return 0;
    }

    public void deleteEvent(CalendarEvents events) {

    }
}
