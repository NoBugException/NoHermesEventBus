package com.example.nohermeseventbus.hermes;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.nohermeseventbus.MyService;
import com.example.nohermeseventbus.message.EventMessage;
import com.example.nohermeseventbus.message.IEventMessage;

public class NoHermes {

    // 静态内部类单例
    public static NoHermes getDefault(){
        return NoHermesHolder.instance;
    }

    static class NoHermesHolder{
        public static NoHermes instance = new NoHermes();
    }


    /**
     * 注册
     * @param clazz
     */
    public void register(Class clazz){

    }


    /**
     * 连接
     */
    public void connect(Context context, Class serviceClazz, IConnectCallback callback) {

        Intent intent = new Intent(context, serviceClazz);
        context.bindService(intent, new ServiceConnection() {
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
        context.startService(intent);
    }
}
