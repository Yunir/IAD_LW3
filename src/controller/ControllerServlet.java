package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private boolean correct=false;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/main.xhtml").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String enterX = request.getParameter("enterX");
            String enterY = request.getParameter("enterY");
            String R = request.getParameter("enterR");
            double x = Double.parseDouble(enterX);
            double y = Double.parseDouble(enterY);
            double r = Double.parseDouble(R);
            //System.out.println(x + " " + y + " " + r);
            request.setAttribute("enterX", x);
            request.setAttribute("enterY", y);
            request.setAttribute("enterR", r);
            request.getRequestDispatcher("/check").forward(request, response);
        }
        catch(Exception exception) {
            System.out.println("WE HAVE SOME PROBLEMS, Huston!?");
        }
    }
}
