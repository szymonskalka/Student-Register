/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.skalka.sslab1.modelPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the student class
 *
 * @version 2.0
 * @author szymon skalka
 */
public final class Student implements Average {

    /**
     * Student's ID
     */
    private int id;
    /**
     * Students name
     */
    private String name;
    /**
     * Students surname
     */
    private String surname;
    /**
     * Students total average grade
     */
    private Float averageGrade;
    /**
     * List of subjects
     */
    private List<Subject> subjects;

    /**
     * Constructor
     *
     * @param newID Student ID
     * @param newName Name
     * @param newSurname Surname
     */
    public Student(int newID, String newName, String newSurname) {
        subjects = new ArrayList<>();
        setID(newID);
        setName(newName);
        setSurname(newSurname);
        averageGrade = 1.0f;
    }

    ;
        
        
        /**
         * ID setter
         * @param newID Student ID
         */
        public void setID(int newID) {
        this.id = newID;
    }

    /**
     * ID getter
     *
     * @return id
     */
    public int getID() {
        return id;
    }

    /**
     * Name setter
     *
     * @param newName Name
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Name getter
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Surname setter
     *
     * @param newSurname Surname
     */
    public void setSurname(String newSurname) {
        this.surname = newSurname;
    }

    /**
     * Surname getter
     *
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Adds a subject to the subjects list and calculates the new total average
     * grade
     *
     * @param newSubjectName Subject Name
     */
    public void addSubject(String newSubjectName) {
        this.subjects.add(new Subject(newSubjectName, this.subjects.size()));
        this.calculateAVG();
    }

    /**
     * Subjects list getter
     *
     * @return subjects
     */
    public List<Subject> getSubjects() {
        return subjects;
    }

    /**
     * Returns the subjects list length
     *
     * @return size of subjects
     */
    public int getSubjectsLength() {
        return subjects.size();
    }

    /**
     * Calculates the average grade using stream forEach() method
     */
    public void calculateAVG() {
        averageGrade = 0.f;
        // stream for each loop
        subjects.stream().forEach((subject) -> {
        averageGrade +=subject.getAVG();
        });
      
        averageGrade /= subjects.size();
    }

    /**
     * Returns the average grade
     *
     * @return averageGrade
     */
    public Float getAVG() {
        return averageGrade;
    }

}
