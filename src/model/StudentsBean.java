package model;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name = "StudentsBean", eager = true)
@ApplicationScoped
public class StudentsBean implements Serializable {
    private static ArrayList<StudentsBean> list=new ArrayList<StudentsBean>();
    private String table = null;
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
    public static int getSizeList(){
        return list.size();
    }
    public String getTable() {
        return table;
    }
    public void setTable(String table) {
        this.table = table;
    }
}
