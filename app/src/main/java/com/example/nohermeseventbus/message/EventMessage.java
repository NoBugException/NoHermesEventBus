package com.example.nohermeseventbus.message;

import android.os.Parcel;
import android.os.Parcelable;

public class EventMessage implements Parcelable {

    private String eventName;

    public EventMessage(){}

    protected EventMessage(Parcel in) {
        eventName = in.readString();
    }

    public static final Creator<EventMessage> CREATOR = new Creator<EventMessage>() {
        @Override
        public EventMessage createFromParcel(Parcel in) {
            return new EventMessage(in);
        }

        @Override
        public EventMessage[] newArray(int size) {
            return new EventMessage[size];
        }
    };

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(eventName);
    }
}
