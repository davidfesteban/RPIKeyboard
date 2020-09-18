/**
 * AUTOMATIC GENERATED FROM http://www.jsonschema2pojo.org/
 */

package mapper.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpecialCharsModel {

    @SerializedName("character")
    @Expose
    private String character;
    @SerializedName("value")
    @Expose
    private int value;

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
