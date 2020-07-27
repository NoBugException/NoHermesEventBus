package com.example.nohermeseventbus.message;

public interface IEventMessage extends android.os.IInterface
{
  /** Default implementation for IEventMessage. */
  public static class Default implements com.example.nohermeseventbus.message.IEventMessage
  {
    @Override public com.example.nohermeseventbus.message.EventMessage getEventMessage() throws android.os.RemoteException
    {
      return null;
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.example.nohermeseventbus.message.IEventMessage
  {
    private static final java.lang.String DESCRIPTOR = "com.example.nohermeseventbus.message.IEventMessage";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.example.nohermeseventbus.message.IEventMessage interface,
     * generating a proxy if needed.
     */
    public static com.example.nohermeseventbus.message.IEventMessage asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.example.nohermeseventbus.message.IEventMessage))) {
        return ((com.example.nohermeseventbus.message.IEventMessage)iin);
      }
      return new com.example.nohermeseventbus.message.IEventMessage.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      java.lang.String descriptor = DESCRIPTOR;
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
        case TRANSACTION_getEventMessage:
        {
          data.enforceInterface(descriptor);
          com.example.nohermeseventbus.message.EventMessage _result = this.getEventMessage();
          reply.writeNoException();
          if ((_result!=null)) {
            reply.writeInt(1);
            _result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
          }
          else {
            reply.writeInt(0);
          }
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.example.nohermeseventbus.message.IEventMessage
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public java.lang.String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      @Override public com.example.nohermeseventbus.message.EventMessage getEventMessage() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        com.example.nohermeseventbus.message.EventMessage _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getEventMessage, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getEventMessage();
          }
          _reply.readException();
          if ((0!=_reply.readInt())) {
            _result = com.example.nohermeseventbus.message.EventMessage.CREATOR.createFromParcel(_reply);
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
      public static com.example.nohermeseventbus.message.IEventMessage sDefaultImpl;
    }
    static final int TRANSACTION_getEventMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
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
  public com.example.nohermeseventbus.message.EventMessage getEventMessage() throws android.os.RemoteException;
}
