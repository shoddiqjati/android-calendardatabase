package com.onevest.dev.calendardatabase.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.onevest.dev.calendardatabase.R;
import com.onevest.dev.calendardatabase.helper.DatabaseHandler;
import com.onevest.dev.calendardatabase.model.CalendarEvents;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {

    private Context context;
    private List<CalendarEvents> events;

    public EventsAdapter(Context context) {
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTV, timeTV, iconTV;
        public MyViewHolder(View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            timeTV = itemView.findViewById(R.id.timeTV);
            iconTV = itemView.findViewById(R.id.iconText);
        }
    }

    @Override
    public EventsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_event, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EventsAdapter.MyViewHolder holder, int position) {
        DatabaseHandler databaseHandler = new DatabaseHandler(context);
        events = databaseHandler.getAllEvents();
        String eventTitle = events.get(position).getEventTitle();
        holder.titleTV.setText(eventTitle);
        holder.timeTV.setText(events.get(position).getEventStartTime() + ", " +
                events.get(position).getEventEndTime());
        holder.iconTV.setText(eventTitle.substring(0, 1));
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
