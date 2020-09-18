package connection;

import interfaces.IOConnectionInterface;

import java.io.InputStream;
import java.io.OutputStream;

public class BluetoothConnection implements IOConnectionInterface {
    @Override
    public InputStream getInputStream() {
        return null;
    }

    @Override
    public OutputStream getOutputStream() {
        return null;
    }

    @Override
    public boolean isInterfaceAvaliable() {
        return false;
    }

    @Override
    public boolean isKeyboardVisible() {
        return false;
    }

    @Override
    public boolean getConnection() {
        return false;
    }

}
