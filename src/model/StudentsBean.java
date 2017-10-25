package model;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "StudentsBean", eager = true)
@ApplicationScoped
public class StudentsBean implements Serializable {
    private String enterX = null; private double x;
    private String enterY = null; private double y;
    private String enterR = null; private int r;
    private String result = null; private boolean res;

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

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public int getR() {
        return r;
    }
    public void setR(int r) {
        this.r = r;
    }
    public boolean isRes() {
        return res;
    }
    public void setRes(boolean res) {
        this.res = res;
    }

    /////////////////////////////////////////////////////////////////////////////////

    Connection connection;

    public Connection getConnection(){
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/IAD_LW3","postgres","54321");
        }catch(Exception e){
            System.out.println(e);
        }
        return connection;
    }

    public List<StudentsBean> getHitsList() throws ClassNotFoundException, SQLException {

        Connection connect = getConnection();

        List<StudentsBean> list = new ArrayList<StudentsBean>();
        PreparedStatement pstmt = connect
                .prepareStatement("select x, y, r, answer from hit_to_graph");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            StudentsBean next = new StudentsBean();
            next.setX(rs.getDouble("x"));
            next.setY(rs.getDouble("y"));
            next.setR(rs.getInt("r"));
            next.setRes(rs.getBoolean("answer"));

            list.add(next);

        }

        // close resources
        rs.close();
        pstmt.close();
        connect.close();

        return list;

    }

    public String addToList(){
        int resultt = 0;
        try{
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\nAAAAAAAAAAAAAAAAA\n" + discryptX(enterX) + " " + enterY + " " + enterR + " " + result);
            connection = getConnection();
            double xx = discryptX(enterX);
            double yy = Double.parseDouble(enterY);
            int rr = Integer.parseInt(enterR);
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO hit_to_graph(user_id, x, y, r, answer) values(1, ?, ?, ?, ?)");
            stmt.setDouble(1, xx);
            stmt.setDouble(2, yy);
            stmt.setInt(3, rr);
            stmt.setBoolean(4, checkArea(xx, yy, rr));
            resultt = stmt.executeUpdate();
            connection.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return "view/main.xhtml?faces-redirect=true";
    }

    public double discryptX(String x) {
        switch (x) {
            case "enterX1":
                return -2;
            case "enterX2":
                return -1.5;
            case "enterX3":
                return -1;
            case "enterX4":
                return -0.5;
            case "enterX5":
                return 0;
            case "enterX6":
                return 0.5;
            case "enterX7":
                return 1;
            case "enterX8":
                return 1.5;
            case "enterX9":
                return 2;
            default:
                return Double.parseDouble(x);
        }
    }

    public void defineR(int i) {
        switch(i) {
            case 1:
                enterR = 1 + "";
                break;
            case 2:
                enterR = 2 + "";
                break;
            case 3:
                enterR = 3 + "";
                break;
            case 4:
                enterR = 4 + "";
                break;
            case 5:
                enterR = 5 + "";
                break;
            default:
                enterR = 1 + "";
                break;
        }
        //System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\nAAAAAAAAAAAAAAAAA\n" + enterR);
    }

    private boolean checkArea(double x, double y, double r){
        //System.out.println(x + " " + y + " " + r + " " + (x >= 0 && y >= 0) + (x <= r) + (y <= (r/2)) + " " + y + " " + r/2);
        if((x >= 0 && y >= 0) && (x <= r) && (y <= (r/2))){
            System.out.println("1st! rectangle!");
            return true;
        }
        else if(x >= 0 && y <= 0 && y >= (x-(r/2))){
            System.out.println("2nd! triangle!");
            return true;
        }
        else if (x <= 0 && y >= 0 && (r/2) >= Math.sqrt(y*y+x*x)){
            System.out.println("3rd! circle!");
            return true;
        }
        else {
            System.out.println("Why there's mistake?!");
            return false;
        }
    }
}
