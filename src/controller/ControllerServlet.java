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
            PrintWriter writer=response.getWriter();
            String[] enterX = request.getParameterValues("enterX");
            String[] enterY = request.getParameterValues("enterY");
            String[] R = request.getParameterValues("enterR");
            double x = 0;
            double y = 0;
            double r = 0;
            if (enterX.length != 1 || enterY.length != 1 || R.length != 1) {
                correct = false;
            } else {
                x = round(Double.parseDouble(enterX[0]), 2);
                y = round(Double.parseDouble(enterY[0]), 2);
                r = round(Double.parseDouble(R[0]), 2);
                if (x >= -2 && x <= 2 && y >= -5 && y <= 5 && r >= 1 && r <= 5) correct = true;
                else correct = false;
            }
            if (!correct) {
                request.getRequestDispatcher("view/main.xhtml").forward(request, response);
            } else {
                request.setAttribute("enterX", x);
                request.setAttribute("enterY", y);
                request.setAttribute("enterR", r);
                request.getRequestDispatcher("/check").forward(request, response);
            }
        }
        catch(Exception exception) {
            request.getRequestDispatcher("/view/main.xhtml").forward(request, response);
        }
    }
    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
