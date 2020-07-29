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

import com.example.nohermeseventbus.hermes.IConnectCallback;
import com.example.nohermeseventbus.hermes.NoHermes;
import com.example.nohermeseventbus.message.EventMessage;
import com.example.nohermeseventbus.message.IEventMessage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        NoHermes.getDefault().register();

        NoHermes.getDefault().connect(getApplicationContext(), MyService.class, new IConnectCallback() {
            @Override
            public void connectSuccess() {
                // 连接成功

            }

            @Override
            public void connectFailed() {
                // 连接失败

            }
        });
    }
}
