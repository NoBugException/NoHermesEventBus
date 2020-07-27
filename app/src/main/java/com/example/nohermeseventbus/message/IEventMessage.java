package com.example.nohermeseventbus.message;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IEventMessage extends IInterface {

  public static abstract class Stub extends Binder implements IEventMessage {

    private static final String DESCRIPTOR = "com.example.nohermeseventbus.message.IEventMessage";

    public Stub() {
      this.attachInterface(this, DESCRIPTOR);
    }


    /**
     * 生成代理
     * @param obj
     * @return
     */
    public static IEventMessage asInterface(IBinder obj) {

      if (obj == null)
        return null;

      IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (iin!=null && iin instanceof IEventMessage) {
        return (IEventMessage)iin;
      }
      return new Proxy(obj);
    }

    /**
     * 获取Binder对象
     * @return
     */
    @Override
    public IBinder asBinder() {
      return this;
    }

    @Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
      String descriptor = DESCRIPTOR;
      switch (code) {
        case INTERFACE_TRANSACTION: {
          reply.writeString(descriptor);
          return true;
        }
        case TRANSACTION_getEventMessage: {
          data.enforceInterface(descriptor);
          EventMessage _result = this.getEventMessage();
          reply.writeNoException();
          if ((_result!=null)) {
            reply.writeInt(1);
            _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
          } else {
            reply.writeInt(0);
          }
          return true;
        }
        default:
          return super.onTransact(code, data, reply, flags);
      }
    }

    /**
     * 代理类
     */
    private static class Proxy implements IEventMessage {

      private IBinder mRemote;
      Proxy(IBinder remote) {
        mRemote = remote;
      }

      @Override
      public IBinder asBinder() {
        return mRemote;
      }


      public String getInterfaceDescriptor() {
        return DESCRIPTOR;
      }

      @Override
      public EventMessage getEventMessage() throws RemoteException {
        Parcel _data = Parcel.obtain();
        Parcel _reply = Parcel.obtain();
        EventMessage _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getEventMessage, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getEventMessage();
          }
          _reply.readException();
          if ((0!=_reply.readInt())) {
            _result = EventMessage.CREATOR.createFromParcel(_reply);
          }
          else {
            _result = null;
          }
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      public static IEventMessage sDefaultImpl;
    }

    static final int TRANSACTION_getEventMessage = (IBinder.FIRST_CALL_TRANSACTION + 0);

    public static boolean setDefaultImpl(com.example.nohermeseventbus.message.IEventMessage impl) {
      if (Stub.Proxy.sDefaultImpl == null && impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }

    public static com.example.nohermeseventbus.message.IEventMessage getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }

  public EventMessage getEventMessage() throws RemoteException;
}
