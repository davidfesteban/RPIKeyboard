package mapper;

import com.google.gson.Gson;
import mapper.pojo.KeyModel;
import mapper.pojo.SpecialCharsModel;
import utils.EnhancedListUtil;
import utils.KeyEventUtil;

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
        List<?> listInRange = getListFromValue(inputInteger);

        if (listInRange.get(0) instanceof SpecialCharsModel) {
            SpecialCharsModel specialCharsModel = (SpecialCharsModel) new EnhancedListUtil<>(listInRange).searchUntil("value", Integer.toString(inputInteger));
            keyResultQueue.offer(KeyEventUtil.getKeyEventFromName(specialCharsModel.getCharacter())); //VK_SHIFT
        } else {

        }

        return keyResultQueue;
    }

    private List<?> getListFromValue(int inputInteger) {
        List<?> result = keyModel.getNumbers();

        if (keyModel.getMinus().contains(inputInteger)) {
            result = keyModel.getMinus();
        } else if (isInSpecialCharsModel(keyModel.getSpecialABC(), inputInteger)) {
            result = keyModel.getSpecialABC();
        } else if (isInSpecialCharsModel(keyModel.getSpecialABC2(), inputInteger)) {
            result = keyModel.getSpecialABC2();
        } else if (isInSpecialCharsModel(keyModel.getSpecialCharModels(), inputInteger)) {
            result = keyModel.getSpecialCharModels();
        }

        return result;
    }

    private boolean isInSpecialCharsModel(List<SpecialCharsModel> list, int inputInteger) {
        boolean result = false;
        if (list.get(0).getValue() <= inputInteger && list.get(list.size() - 1).getValue() >= inputInteger) {
            result = true;
        }
        return result;
    }

}
