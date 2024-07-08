/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllerPackage;

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
@WebServlet("/FormAddStudent")
public class AddStudentServlet extends HttpServlet {

    /**
     * Controller object
     */
    private Controller controller;

    /**
     * Default Constructor
     *
     */
    public AddStudentServlet() {
        controller = new Controller();
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
            // Get parameter values - firstName i lastName
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");

            // FirstName or lastName was not given - send error message
            if (firstName.length() == 0 || lastName.length() == 0) {
                response.sendError(response.SC_BAD_REQUEST, "You should give two parameters!");
            } else {
                if (request.getSession().getAttribute("controller") != null) {
                    controller = (Controller) request.getSession().getAttribute("controller");
                }

                controller.addStudent(firstName, lastName);

                out.println("<html>\n<body>\n<h1>Student added.</h1>\n");

                out.println("Name: " + controller.getModel().getLastStudent().getName() + "\n<br>");
                out.println("Surame: " + controller.getModel().getLastStudent().getSurname() + "\n<br>");
                out.println("ID: " + controller.getModel().getLastStudent().getID() + "\n<br><br>");
                out.println("<form>\n"
                        + " <input type=\"button\" value=\"Go back!\" onclick=\"history.back()\">\n"
                        + "</form>");
                out.println("</body>\n</html>");

                request.getSession().setAttribute("controller", controller);
            }
        }
    }

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
