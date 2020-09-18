/**
 * AUTOMATIC GENERATED FROM http://www.jsonschema2pojo.org/
 */

package mapper.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KeyModel {

    @SerializedName("numbers")
    @Expose
    private List<Integer> numbers = null;
    @SerializedName("mayus")
    @Expose
    private List<Integer> mayus = null;
    @SerializedName("minus")
    @Expose
    private List<Integer> minus = null;
    @SerializedName("specialABC")
    @Expose
    private List<SpecialCharsModel> specialABC = null;
    @SerializedName("specialABC2")
    @Expose
    private List<SpecialCharsModel> specialABC2 = null;
    @SerializedName("specialCharModels")
    @Expose
    private List<SpecialCharsModel> specialCharModels = null;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getMayus() {
        return mayus;
    }

    public void setMayus(List<Integer> mayus) {
        this.mayus = mayus;
    }

    public List<Integer> getMinus() {
        return minus;
    }

    public void setMinus(List<Integer> minus) {
        this.minus = minus;
    }

    public List<SpecialCharsModel> getSpecialABC() {
        return specialABC;
    }

    public void setSpecialABC(List<SpecialCharsModel> specialABC) {
        this.specialABC = specialABC;
    }

    public List<SpecialCharsModel> getSpecialABC2() {
        return specialABC2;
    }

    public void setSpecialABC2(List<SpecialCharsModel> specialABC2) {
        this.specialABC2 = specialABC2;
    }

    public List<SpecialCharsModel> getSpecialCharModels() {
        return specialCharModels;
    }

    public void setSpecialCharModels(List<SpecialCharsModel> specialCharModels) {
        this.specialCharModels = specialCharModels;
    }

}
