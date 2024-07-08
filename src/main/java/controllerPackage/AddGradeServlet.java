/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllerPackage;

import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.polsl.skalka.sslab1.modelPackage.IndexOutOfRegisterException;

import java.io.IOException;

/**
 *
 * @author SuperStudent-PL
 */
@WebServlet("/FormAddGrade")
public class AddGradeServlet extends HttpServlet {

    /**
     * Controller object
     */
    private Controller controller;

    /**
     * Default Constructor
     *
     */
    public AddGradeServlet() {
        //model = new Register();
        //view = new ViewServlet();
        controller = new Controller();
        //controller.getModel().addStudent("b", "b");
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
            int studentID = Integer.parseInt(request.getParameter("studentID"));
            int subjectID = Integer.parseInt(request.getParameter("subjectID"));
            int grade = Integer.parseInt(request.getParameter("grade"));
            int gradeWeight = Integer.parseInt(request.getParameter("gradeWeight"));

            // FirstName or lastName was not given - send error message
            if (Integer.valueOf(studentID) == null || Integer.valueOf(subjectID) == null
                    || Integer.valueOf(grade) == null || Integer.valueOf(gradeWeight) == null) {
                response.sendError(response.SC_BAD_REQUEST, "You should give two parameters!");
            } else {
                try {
                    if (request.getSession().getAttribute("controller") != null) {
                        controller = (Controller) request.getSession().getAttribute("controller");
                    }
                    
                    Cookie[] cookies = request.getCookies();
                    int totalGradesAdded = 0;
                    if (cookies != null) {
                        for (Cookie cookie : cookies) {
                            totalGradesAdded++;
                        }
                    }
                  

                    Cookie cookie = new Cookie("lastVisit", new java.util.Date().toString().replace(' ','_'));
                    response.addCookie(cookie);
                    
                    

                    controller.getModel().addGrade(studentID, subjectID, grade, gradeWeight);
                    out.println("<html>\n<body>\n<h1>Grade added.</h1>\n");
                    out.println("Student Name: " + controller.getModel().getStudents().get(studentID).getName() + "\n<br>");
                    out.println("Student Surame: " + controller.getModel().getStudents().get(studentID).getSurname() + "\n<br>");
                    out.println("Student ID: " + controller.getModel().getStudents().get(studentID).getID() + "\n<br>");
                    out.println("Student AVG: " + controller.getModel().getStudents().get(studentID).getAVG() + "\n<br>");
                    out.println("Subject Name: " + controller.getModel().getStudents().get(studentID).getSubjects().
                            get(subjectID).getName() + "\n<br>");
                    out.println("Subject ID: " + controller.getModel().getStudents().get(studentID).getSubjects().
                            get(subjectID).getID() + "\n<br>");
                    out.println("Subject AVG: " + controller.getModel().getStudents().get(studentID).getSubjects().
                            get(subjectID).getAVG() + "\n<br><br>");

                    out.println("<form>\n"
                            + " <input type=\"button\" value=\"Go back!\" onclick=\"history.back()\">\n"
                            + "</form><br><br>");
                    out.println("Total Grades added: " + totalGradesAdded +"\n<br><br>");
                    out.println("</body>\n</html>");

                    request.getSession().setAttribute("controller", controller);

                } catch (IndexOutOfRegisterException ex) {
                    Logger.getLogger(AddGradeServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
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
