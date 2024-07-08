/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllerPackage;

import ViewPackage.ViewServlet;

import pl.polsl.skalka.sslab1.modelPackage.Register;
import pl.polsl.skalka.sslab1.modelPackage.IndexOutOfRegisterException;

/**
 * This is the controller class of the MVC pattern.
 *
 * @version 2.0
 * @author SuperStudent-PL
 */
public class Controller {

    /**
     * View part of The MVC pattern.
     */
    private final ViewServlet view;
    /**
     * View model of The MVC pattern.
     */
    private final Register model;

    /**
     * Constructor
     *
     * @param model Model
     * @param view View
     */
    public Controller(Register model, ViewServlet view) {
        this.view = view;
        this.model = model;
    }

    /**
     * Default Constructor
     *
     *
     */
    public Controller() {
        this.view = new ViewServlet();
        this.model = new Register();
    }

    public Register getModel() {
        return this.model;
    }

    /**
     * Method used to add students.
     *
     * @param newName Name of the new student
     * @param newSurname Surname f the new student
     */
    public void addStudent(String newName, String newSurname) {
        model.addStudent(newName, newSurname);
    }

    /**
     * Method used to add subjects to students Can throw an user defined exception
     *
     * @param studentID ID of the student to which the subject is going to be assigned to
     * @param newSubjectName Name of the new Subject
     */
    public void addSubject(int studentID, String newSubjectName) {

        try {
            model.addSubject(studentID, newSubjectName);
        } catch (IndexOutOfRegisterException ex) {
            System.out.println("Exception occured: " + ex);
        }

    }

    /**
     * Used to add grades
     *
     * @param studentID ID of the student to which the grade is going to be added to
     * @param subjectID ID of the subject to which the grade is going to be added to
     * @param newGrade Grade that is going to be added
     * @param newWeight Weight of the grade that is going to be added
     */
    public void addGrade(int studentID, int subjectID, int newGrade, int newWeight) {
        try {
            model.addGrade(studentID, subjectID, newGrade, newWeight);
        } catch (IndexOutOfRegisterException ex) {
            System.out.println("Exception occured: " + ex);
        }
    }

    /**
     * Prints out all the student data
     *
     * @deprecated
     * @param studentID ID of the student
     */
    public void updateView(int studentID) {
        //    view.printStudentData(model.getStudents().get(studentID).getID(), model.getStudents().get(studentID).getName(),
        //            model.getStudents().get(studentID).getSurname(), model.getStudents().get(studentID).getAVG());
    }

    /**
     * 3
     * Only works when there are at least 2 students in the register.
     */
    public void fillWithData() {

        this.addSubject(0, "Matematyka");
        this.addGrade(0, 0, 5, 2);
        this.addGrade(0, 0, 5, 1);

        this.addSubject(0, "Fizyka");
        this.addGrade(0, 1, 2, 3);
        this.addGrade(0, 1, 2, 2);

        this.addSubject(1, "Matematyka");
        this.addGrade(1, 0, 4, 2);
        this.addGrade(1, 0, 5, 1);
    }

}
