/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ViewPackage;

import controllerPackage.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

/**
 *
 * @author SuperStudent-PL
 */
@WebServlet("/FormShowStudetnsList")
public class ViewServlet extends HttpServlet {

    /**
     * Default Constructor
     *
     */
    public ViewServlet() {
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=ISO-8859-2");
        try (PrintWriter out = response.getWriter()) {
            Controller controller = new Controller();
            if (request.getSession().getAttribute("controller") != null) {
                controller = (Controller) request.getSession().getAttribute("controller");
            }

            out.println("<html>\n<body>\n<h1>All students in Register</h1>\n");

            for (int studentID = 0; studentID < controller.getModel().getStudents().size(); studentID++) {
                out.println("Student Name: " + controller.getModel().getStudents().get(studentID).getName() + "\n<br>");
                out.println("Student Surame: " + controller.getModel().getStudents().get(studentID).getSurname() + "\n<br>");
                out.println("Student ID: " + controller.getModel().getStudents().get(studentID).getID() + "\n<br>");
                out.println("Student AVG: " + controller.getModel().getStudents().get(studentID).getAVG() + "\n<br>");
                out.println("\n<br>");
            }
            out.println("<form>\n"
                    + " <input type=\"button\" value=\"Go back!\" onclick=\"history.back()\">\n"
                    + "</form>");
            out.println("</body>\n</html>");
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

}
