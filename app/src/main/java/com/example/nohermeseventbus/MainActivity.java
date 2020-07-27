package com.example.nohermeseventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.nohermeseventbus.message.EventMessage;
import com.example.nohermeseventbus.message.IEventMessage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            startForegroundService(intent);
//        } else {
//            startService(intent);
//        }

        Intent intent = new Intent(MainActivity.this, MyService.class);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.d("yunchong", "连接成功");
                IEventMessage iEventMessage = IEventMessage.Stub.asInterface(service);
                if(iEventMessage != null){
                    try {
                        EventMessage eventMessage = iEventMessage.getEventMessage();
                        Log.d("yunchong", "从服务器取到的值："+eventMessage.getEventName());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.d("yunchong", "连接失败");
            }
        }, Context.BIND_AUTO_CREATE);
        startService(intent);
    }
}
