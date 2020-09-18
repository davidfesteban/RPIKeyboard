package connection;

import com.fazecast.jSerialComm.SerialPort;
import interfaces.IOConnectionInterface;
import main.Config;

import java.io.InputStream;
import java.io.OutputStream;


public class SerialConnection implements IOConnectionInterface {

    private SerialPort[] serialPortArray;
    private SerialPort serialPort;

    private boolean connectionAvaliable;

    public SerialConnection() {
        serialPortArray = SerialPort.getCommPorts();
        serialPort = null;
        connectionAvaliable = false;
    }

    @Override
    public InputStream getInputStream() {
        InputStream result = null;
        if(connectionAvaliable) {
            result = serialPort.getInputStream();
        } //Else exception
        return result;
    }

    @Override
    public OutputStream getOutputStream() {
        OutputStream result = null;
        if(connectionAvaliable) {
            result = serialPort.getOutputStream();
        } //Else exception
        return result;
    }

    @Override
    public boolean isInterfaceAvaliable() {
        return serialPortArray.length > 0;
    }

    @Override
    public boolean isKeyboardVisible() {
        boolean result = false;

        for (int i = 0; i < serialPortArray.length && !result; ++i) {
            result = haveFoundPortAndAssigned(serialPortArray[i]);
        }

        return result;
    }

    @Override
    public boolean getConnection() {
        serialPort.closePort();
        connectionAvaliable = serialPort.openPort();
        //serialPort.setBaudRate(Config.SERIAL_BAUDRATE);
        return connectionAvaliable;
    }


    /**
     * PRIVATE ZONE
     */

    private boolean haveFoundPortAndAssigned(SerialPort serialPort) {
        boolean result = serialPort.getPortDescription().equalsIgnoreCase(Config.PORT_DESCRIPTION);

        if(result) {
            this.serialPort = serialPort;
        }

        return result;
    }
}
