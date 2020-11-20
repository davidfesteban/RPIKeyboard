package utils;

import java.awt.event.KeyEvent;

public class KeyEventUtil {

    private KeyEventUtil() {
        //Contextual
    }

    public static int getKeyEventFromName(String name) {
        int result = 0;

        try {
            result = KeyEvent.class.getDeclaredField(name).getInt(null);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }
}
