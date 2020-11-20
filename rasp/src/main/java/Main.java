import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import java.util.logging.Logger;

public class Main extends javax.swing.JFrame implements NativeKeyListener {


    public static void main(String... args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {

        }
        GlobalScreen.addNativeKeyListener(new Main());
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {

        System.out.println(nke.getRawCode() - 'A' + 10);

//        System.out.println(nke.getRawCode());
        /*switch (nke.getRawCode()) {
            case 8:
                SaveLogs("[Backspace]");
                break;
        }*/
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
        //System.out.println(nke.getRawCode());
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
        //System.out.println(nke.getRawCode());
    }
}

