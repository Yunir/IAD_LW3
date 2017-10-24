package model;

import javax.annotation.Resource;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.sql.DataSource;
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
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO hit_to_graph(user_id, x, y, r, answer) values(1, ?, ?, ?, ?)");
            stmt.setDouble(1, discryptX(enterX));
            stmt.setDouble(2, Double.parseDouble(enterY));
            stmt.setInt(3, Integer.parseInt(enterR));
            stmt.setBoolean(4, Boolean.parseBoolean(result));
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
                return 0;
        }
    }
}
