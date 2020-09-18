package main;

import java.io.OutputStream;

public class Client extends Thread {

    private final OutputStream outputStream;

    public Client (OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        super.run();
    }
}
