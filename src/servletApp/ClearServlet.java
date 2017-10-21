package servletApp;

import beans.StudentsBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClearServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int k=StudentsBean.getList().size();
        for(int i=0; i< k; i++){
            StudentsBean.getList().remove(0);
        }
    }
}
