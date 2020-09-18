package main;

import connection.BluetoothConnection;
import connection.SerialConnection;
import interfaces.IOConnectionInterface;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    private static Client client = null;
    private static Server server = null;

    private static IOConnectionInterface connectionInterface = null;

    private static InputStream inputStream = null;
    private static OutputStream outputStream = null;

    public static void main(String... args) {
        getConfiguration();
        createIOInterfaces();
        getConnection();
        getIOStreams();
        createSystem();
        runSystem();
    }

    private static void getConfiguration() {
        //Get basic config. Baud rate, Current OS
    }

    //Get and recognise RPI in Bluetooth or Serial
    private static void createIOInterfaces() {
        Iterator<IOConnectionInterface> listIterator;
        List<IOConnectionInterface> connectionInterfaceList = new ArrayList<>();

        connectionInterfaceList.add(new SerialConnection());
        connectionInterfaceList.add(new BluetoothConnection());

        listIterator = connectionInterfaceList.iterator();
        do {
            connectionInterface = listIterator.next();
        } while (listIterator.hasNext() && !connectionInterface.isInterfaceAvaliable() && !connectionInterface.isKeyboardVisible());

        if (!connectionInterface.isKeyboardVisible()) {
            //Throw connection
        }
    }

    //Get Connection
    private static void getConnection() {
        connectionInterface.getConnection();
    }

    //Obtain Input or Output stream from connection interface
    private static void getIOStreams() {
        inputStream = connectionInterface.getInputStream();
        outputStream = connectionInterface.getOutputStream();
    }

    private static void createSystem() {
        try{
            client = new Client(outputStream);
            server = new Server(inputStream);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void runSystem() {
        client.start();
        server.start();
    }
}
