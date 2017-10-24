package model;

import javax.annotation.Resource;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "Students", eager = true)
@ApplicationScoped
public class StudentsBean {

    /*@Resource(name="jdbc:postgresql://localhost:5432/IAD_LW3")
    private DataSource ds;
    public List<StudentBean> getHitsList() throws SQLException {
        if(ds==null)
            throw new SQLException("Can't get data source");
        Connection con = ds.getConnection();
        if(con==null)
            throw new SQLException("Can't get database connection");
        PreparedStatement ps
                = con.prepareStatement(
                "select x, y, r, answer from hit_to_graph");

        //get customer data from database
        ResultSet result =  ps.executeQuery();

        List<StudentBean> list = new ArrayList<StudentBean>();

        while(result.next()){
            StudentBean next = new StudentBean();

            next.setX(result.getDouble("x"));
            next.setY(result.getDouble("y"));
            next.setR(result.getInt("r"));
            next.setRes(result.getBoolean("answer"));
            //store all data into a List
            list.add(next);
        }

        return list;
    }*/

    public List<StudentBean> getHitsList() throws ClassNotFoundException, SQLException {

        Connection connect = null;

        String url = "jdbc:postgresql://localhost:5432/IAD_LW3";

        String username = "postgres";
        String password = "54321";

        try {

            Class.forName("org.postgresql.Driver");

            connect = DriverManager.getConnection(url, username, password);
            // System.out.println("Connection established "+connect);

        } catch (SQLException ex) {
            System.out.println("in exec");
            System.out.println(ex.getMessage());
        }

        List<StudentBean> list = new ArrayList<StudentBean>();
        PreparedStatement pstmt = connect
                .prepareStatement("select x, y, r, answer from hit_to_graph");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            StudentBean next = new StudentBean();
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
}
