package mapper;

import com.google.gson.Gson;
import mapper.pojo.KeyModel;

import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Some info about the communication:
 * When pressed in Raspberry a Letter. It doesnt send the same ASCII letter, It sends another because, It can only work
 * between 0 and 255 chars, enough for the communication speed.
 */
public class IntToKeyMapper {

    private Gson gson;
    private KeyModel keyModel;

    public IntToKeyMapper() {
        try {
            this.gson = new Gson();
            this.keyModel = gson.fromJson(new FileReader(getClass().getClassLoader().getResource("data.json").getFile().replace("%20", " ")), KeyModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Queue<Integer> map(int inputInteger) {
        Queue<Integer> keyResultQueue = new LinkedList<>();

        if (isInListInteger(keyModel.getNumbers(), inputInteger)) {
            keyResultQueue.offer(inputInteger + KeyEvent.VK_0);
        } else if (isInListInteger(keyModel.getMayus(), inputInteger)) {
            keyResultQueue.offer(KeyEvent.VK_SHIFT);
            keyResultQueue.offer(inputInteger - keyModel.getMayus().get(0) + KeyEvent.VK_A);
        } else if (isInListInteger(keyModel.getMinus(), inputInteger)) {
            keyResultQueue.offer(inputInteger - keyModel.getMayus().get(0) + KeyEvent.VK_A);
        }

        return keyResultQueue;
    }

    private boolean isInListInteger(List<Integer> integerList, int inputInteger) {
        boolean result = false;
        if (!integerList.isEmpty() && inputInteger >= integerList.get(0) && inputInteger <= integerList.get(integerList.size() - 1)) {
            result = true;
        }
        return result;
    }
}
