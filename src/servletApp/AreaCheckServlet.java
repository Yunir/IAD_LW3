package servletApp;

import beans.StudentsBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter writer=resp.getWriter();
            double enterX=(double)req.getAttribute("enterX");
            double enterY=(double)req.getAttribute("enterY");
            double r=(double)req.getAttribute("enterR");
            boolean isInArea=checkArea(enterX, enterY, r);
            req.setAttribute("enterX", enterX);
            req.setAttribute("enterY", enterY);
            req.setAttribute("enterR", r);
            req.setAttribute("isInArea", isInArea);
            StudentsBean bean=new StudentsBean();
            bean.setEnterR(String.valueOf(r));
            bean.setEnterX(String.valueOf(enterX));
            bean.setEnterY(String.valueOf(enterY));
            bean.setResult(String.valueOf(isInArea));
            //resp.sendRedirect("http://localhost:8080/2labaIAD_war_exploded/answer.jsp");
            req.getRequestDispatcher("/answer.jsp").forward(req,resp);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    protected boolean checkArea(double x, double y, double r){
        if(x<=0 && y>=0 && Math.abs(x)<=Math.abs(r) && Math.abs(y)<=Math.abs(r)){
            return true;
        }
        else if(x>=0 && y<=0 && r>=Math.sqrt(y*y+x*x)){
            return true;
        }
        else if(x>=-r/2 && x<=0 && y>=-r && y<=0 && y>=-2*x-2){
            return true;
        }
        else return false;
    }
}
