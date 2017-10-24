package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClearServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO: replace with JDBC cleaner
        /*int k=StudentBean.getList().size();
        for(int i=0; i< k; i++){
            StudentBean.getList().remove(0);
        }*/
    }
}
