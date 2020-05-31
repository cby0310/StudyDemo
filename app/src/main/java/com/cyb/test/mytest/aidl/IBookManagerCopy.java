package com.cyb.test.mytest.aidl;

import android.os.RemoteException;
import android.util.Log;

public interface IBookManagerCopy extends android.os.IInterface {
    /**
     * Local-side IPC implementation stub class.
     */
    public static abstract class Stub extends android.os.Binder implements com.cyb.test.mytest.aidl.IBookManagerCopy {
        private static final java.lang.String DESCRIPTOR = "com.cyb.test.mytest.aidl.IBookManagerCopy";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an com.cyb.test.mytest.aidl.IBookManagerCopy interface,
         * generating a proxy if needed.
         */
        public static com.cyb.test.mytest.aidl.IBookManagerCopy asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);

            try {
                Log.e("TAG_IBookManagerCopy", "obj： "+obj);
                Log.e("TAG_IBookManagerCopy", "iin = " + iin + "  getInterfaceDescriptor：" + obj.getInterfaceDescriptor() + "  DESCRIPTOR:" + DESCRIPTOR);
                Log.e("TAG_IBookManagerCopy", obj.getInterfaceDescriptor().equals(DESCRIPTOR) + "");
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            if (((iin != null) && (iin instanceof com.cyb.test.mytest.aidl.IBookManagerCopy))) {
                Log.e("TAG_IBookManagerCopy", "本身");
                return ((com.cyb.test.mytest.aidl.IBookManagerCopy) iin);
            }

            Log.e("TAG_IBookManagerCopy", "new 代理");
            return new com.cyb.test.mytest.aidl.IBookManagerCopy.Stub.Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_getBookList: {
                    data.enforceInterface(DESCRIPTOR);
                    java.util.List<com.cyb.test.mytest.aidl.Book> _result = this.getBookList();
                    reply.writeNoException();
                    reply.writeTypedList(_result);
                    return true;
                }
                case TRANSACTION_addBook: {
                    data.enforceInterface(DESCRIPTOR);
                    com.cyb.test.mytest.aidl.Book _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = com.cyb.test.mytest.aidl.Book.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    this.addBook(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_addListener: {
                    data.enforceInterface(DESCRIPTOR);
                    com.cyb.test.mytest.aidl.IOnNewBookArrivedListener _arg0;
                    _arg0 = com.cyb.test.mytest.aidl.IOnNewBookArrivedListener.Stub.asInterface(data.readStrongBinder());
                    this.addListener(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_cancelListener: {
                    data.enforceInterface(DESCRIPTOR);
                    com.cyb.test.mytest.aidl.IOnNewBookArrivedListener _arg0;
                    _arg0 = com.cyb.test.mytest.aidl.IOnNewBookArrivedListener.Stub.asInterface(data.readStrongBinder());
                    this.cancelListener(_arg0);
                    reply.writeNoException();
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements com.cyb.test.mytest.aidl.IBookManagerCopy {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                return mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override
            public java.util.List<com.cyb.test.mytest.aidl.Book> getBookList() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.util.List<com.cyb.test.mytest.aidl.Book> _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getBookList, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(com.cyb.test.mytest.aidl.Book.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void addBook(com.cyb.test.mytest.aidl.Book book) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((book != null)) {
                        _data.writeInt(1);
                        book.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_addBook, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void addListener(com.cyb.test.mytest.aidl.IOnNewBookArrivedListener listener) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((listener != null)) ? (listener.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_addListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void cancelListener(com.cyb.test.mytest.aidl.IOnNewBookArrivedListener listener) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((listener != null)) ? (listener.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_cancelListener, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_getBookList = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_addBook = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
        static final int TRANSACTION_addListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
        static final int TRANSACTION_cancelListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    }

    public java.util.List<com.cyb.test.mytest.aidl.Book> getBookList() throws android.os.RemoteException;

    public void addBook(com.cyb.test.mytest.aidl.Book book) throws android.os.RemoteException;

    public void addListener(com.cyb.test.mytest.aidl.IOnNewBookArrivedListener listener) throws android.os.RemoteException;

    public void cancelListener(com.cyb.test.mytest.aidl.IOnNewBookArrivedListener listener) throws android.os.RemoteException;
}
