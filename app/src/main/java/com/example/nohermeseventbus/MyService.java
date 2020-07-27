package com.example.nohermeseventbus;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import com.example.nohermeseventbus.message.EventMessage;
import com.example.nohermeseventbus.message.IEventMessage;

public class MyService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    class MyBinder extends IEventMessage.Stub{

        @Override
        public EventMessage getEventMessage() throws RemoteException {
            EventMessage eventMessage = new EventMessage();
            eventMessage.setEventName("aaa");
            return eventMessage;
        }
    }
}
