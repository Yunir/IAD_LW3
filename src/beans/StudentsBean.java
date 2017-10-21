package beans;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class StudentsBean implements Serializable {
    private static ArrayList<StudentsBean> list=new ArrayList<StudentsBean>();

    private String enterX = null;
    private String enterY = null;
    private String enterR = null;
    private String result = null;

    public StudentsBean() {
        list.add(this);
    }
    public String getEnterX(){
        return enterX;
    }
    public String getEnterY(){
        return enterY;
    }
    public String getEnterR(){
        return enterR;
    }
    public String getResult(){
        return result;
    }
    public void setEnterX(String enterX){
        this.enterX = enterX;
    }
    public void setEnterY(String enterY){
        this.enterY = enterY;
    }
    public void setEnterR(String enterR){
        this.enterR = enterR;
    }
    public void setResult(String result){
        this.result = result;
    }
    public static ArrayList<StudentsBean> getList() {
        return list;
    }
    public static int sizeList(){
        return list.size();
    }
}
