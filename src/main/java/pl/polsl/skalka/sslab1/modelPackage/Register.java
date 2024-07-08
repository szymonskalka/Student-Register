/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.skalka.sslab1.modelPackage;

import java.util.ArrayList;

/**
 * Register class stores all of the students' data
 *
 * @version 3.0
 * @author szymon skalka
 */
public class Register {

    /**
     * Vector of students
     */
    private final ArrayList<Student> students;

    /**
     * Default Constructor
     */
    public Register() {
        students = new ArrayList<>();
    }

    /**
     * Constructor
     *
     * @param args Initial program arguments
     */
    public Register(String... args) {
        students = new ArrayList<>();

        for (int i = 0; i < args.length; i += 2) {
            this.addStudent(args[i], args[i + 1]);
        }

    }

    /**
     * getter for the students list
     *
     * @return students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * getter for the last student
     *
     * @return students
     */
    public Student getLastStudent() {
        return students.get(students.size() - 1);
    }

    /**
     * Method to add students to the register
     *
     * @param newName Name
     * @param newSurname Surname
     */
    public void addStudent(String newName, String newSurname) {
        this.students.add(new Student(students.size(), newName, newSurname));
    }

    /**
     * Method to add subjects to the register Can throw an exception
     *
     * @param studentID Student OD
     * @param newSubjectName New Subject Name
     * @throws IndexOutOfRegisterException Exception thrown by the method
     */
    public void addSubject(int studentID, String newSubjectName) throws IndexOutOfRegisterException {
        if (studentID >= this.students.size()) {
            throw new IndexOutOfRegisterException("Invalid Student ID.");
        }

        this.students.get(studentID).addSubject(newSubjectName);
    }

    /**
     * Method to add grades.
     *
     * @param studentID Student ID
     * @param subjectID Subject ID
     * @param newGrade Grade
     * @param newWeight Weight of the new grade
     * @throws IndexOutOfRegisterException Exception for adding grades do non
     * existent entities
     */
    public void addGrade(int studentID, int subjectID, int newGrade, int newWeight) throws IndexOutOfRegisterException {
        if (studentID >= this.students.size() || subjectID >= this.students.get(studentID).getSubjects().size()) {
            throw new IndexOutOfRegisterException("Invalid Student ID or Subject ID.");
        }
        this.students.get(studentID).getSubjects().get(subjectID).addGrade(newGrade, newWeight);
        this.students.get(studentID).calculateAVG();
    }

}
