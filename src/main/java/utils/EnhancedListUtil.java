package utils;

import java.lang.reflect.Field;
import java.util.List;

public class EnhancedListUtil<T> {

    private int elementPosition;
    private List<T> list;

    public EnhancedListUtil(List<T> list){
        this.list = list;
    }

    /**
     * @param valueStop
     * @return position
     */
    public int searchUntil(String valueStop) {
        searchUntil(null, valueStop);
        return --elementPosition;
    }

    /**
     * @return Desired object
     */
    //If not found, at least, it will return last member
    public T searchUntil(String fieldName, String valueStop) {
        T result = null;
        try {
            elementPosition = 0;
            boolean stop = false;
            while (elementPosition < list.size() && !stop) {
                result = list.get(elementPosition);

                if(fieldName != null) {
                    Field field = result.getClass().getDeclaredField(fieldName);
                    field.setAccessible(true);

                    if(field.get(result).toString().equals(valueStop)) {
                        stop = true;
                    }
                } else if(result.toString().equals(valueStop)) {
                    stop = true;
                }

                ++elementPosition;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }



    public List<T> getList() {
        return list;
    }

    public List<T> setList(List<T> list) {
        this.list = list;
        return list;
    }
}
