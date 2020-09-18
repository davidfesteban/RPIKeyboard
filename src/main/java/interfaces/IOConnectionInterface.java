package interfaces;

import java.io.InputStream;
import java.io.OutputStream;

public interface IOConnectionInterface {

    InputStream getInputStream();

    OutputStream getOutputStream();

    boolean isInterfaceAvaliable();

    boolean isKeyboardVisible();

    boolean getConnection();
}
