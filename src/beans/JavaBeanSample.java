package beans;

import java.io.Serializable;

public class JavaBeanSample implements Serializable{
    private int x;
    private double y;
    private double r;

    public JavaBeanSample(){
        x=0;
        y=0;
        r=0;
    }

    public int getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getR(){
        return r;
    }
    public void setX(Integer x){
        this.x=x;
    }
    public void setY(Double y){
        this.y=y;
    }
    public void setR(Double r){
        this.r=r;
    }
}
