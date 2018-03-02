/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author YonePC
 */
@WebServlet(name = "CalculatorFormServlet", urlPatterns = {"/CalculatorFormServlet"})
public class CalculatorFormServlet extends HttpServlet {

    @EJB
    private CalculatorBean calculatorBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int number1 = Integer.parseInt(request.getParameter("number1"));
        int number2 = Integer.parseInt(request.getParameter("number2"));

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CalculatorFormServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Addition of number1 and number2 is: " + calculatorBean.add(number1, number2) + "</h1>");
            out.println("<h1>Subtraction of number1 and number2 is: " + calculatorBean.subtract(number1, number2) + "</h1>");
            out.println("<h1>Multiplication of number1 and number2 is: " + calculatorBean.multiply(number1, number2) + "</h1>");
            out.println("<h1>Division of number1 and number2 is: " + calculatorBean.division(number1, number2) + "</h1>");
            out.println("Click <a href='index.html'>here</a> to go back");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
