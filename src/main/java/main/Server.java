package main;

import mapper.IntToKeyMapper;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class Server extends Thread {

    private final InputStream inputStream;
    private final Robot robot;

    public Server(InputStream inputStream) throws AWTException{
        this.inputStream = inputStream;
        this.robot = new Robot();
    }

    @Override
    public void run() {
        super.run();
        boolean shouldContinue = true;
        while (shouldContinue) {
            try {
                if (inputStream.available() > 0) {
                    shouldContinue = processInput(read(inputStream), robot);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private int read(InputStream inputStream) throws IOException {
        int inputReaded = inputStream.read();
        return inputReaded;
    }

    //if false, it stops everything
    private boolean processInput(int inputReaded, Robot robot) {
        IntToKeyMapper intToKeyMapper = new IntToKeyMapper();
        Queue<Integer> keyToPress = intToKeyMapper.map(inputReaded);
        while (!keyToPress.isEmpty())
        {
            robot.keyPress(keyToPress.poll());
        }
        return true;
    }
}
