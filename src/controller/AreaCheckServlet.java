package controller;

import model.StudentsBean;

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
            //System.out.println(enterX + " " + enterY + " " + r);
            boolean isInArea=checkArea(enterX, enterY, r);
            //System.out.println(isInArea);
            //TODO: replace with JDBC storage
            req.setAttribute("enterX", enterX);
            req.setAttribute("enterY", enterY);
            req.setAttribute("enterR", r);
            req.setAttribute("isInArea", isInArea);
            StudentsBean bean = new StudentsBean();
            //TODO FIX IT!!
            /*bean.setEnterR(String.valueOf(r));
            bean.setEnterX(String.valueOf(enterX));
            bean.setEnterY(String.valueOf(enterY));
            bean.setResult(String.valueOf(isInArea));*/
            req.getRequestDispatcher("view/answer.xhtml").forward(req,resp);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private boolean checkArea(double x, double y, double r){
        if(x >= 0 && y >= 0 && x <= r && y <= (r/2)){
            return true;
        }
        else if(x >= 0 && y <= 0 && y >= (x-(r/2))){
            return true;
        }
        else if (x <= 0 && y >= 0 && (r/2) >= Math.sqrt(y*y+x*x)){
            return true;
        }
        else return false;
    }
}
