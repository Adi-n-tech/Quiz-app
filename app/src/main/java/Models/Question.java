
package Models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Question {

    @SerializedName("srNo")
    @Expose
    private Integer srNo;
    @SerializedName("que")
    @Expose
    private String que;
    @SerializedName("options")
    @Expose
    private ArrayList<Option> options = null;
    @SerializedName("correctAnsID")
    @Expose
    private String correctAnsID;

    public Integer getSrNo() {
        return srNo;
    }

    public void setSrNo(Integer srNo) {
        this.srNo = srNo;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }

    public String getCorrectAnsID() {
        return correctAnsID;
    }

    public void setCorrectAnsID(String correctAnsID) {
        this.correctAnsID = correctAnsID;
    }

}
