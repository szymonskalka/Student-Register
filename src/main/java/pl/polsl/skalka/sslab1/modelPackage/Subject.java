/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.skalka.sslab1.modelPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the subject class
 *
 * @version 2.0
 * @author SuperStudent-PL
 */
public class Subject implements Average {

    /**
     * Name
     */
    private String name;
    /**
     * Subject ID
     */
    private int id;
    /**
     * List of grades
     */
    private List<Grade> grades;
    /**
     * Final grade
     */
    private Float averageGrade;

    /**
     * constructor
     *
     * @param newName Name
     * @param newID Subject ID
     */
    public Subject(String newName, int newID) {
        grades = new ArrayList<>();
        setName(newName);
        setID(newID);
        averageGrade = 1.0f;
    }

    ;

    /**
     * ID setter
     * @param newID Subject ID
     */
     public final void setID(int newID) {
        this.id = newID;
    }

    /**
     * id getter
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
    public final void setName(String newName) {
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
     * Adds a grade to the grades list and calculates the new final grade
     *
     * @param newGrade Grade
     * @param newWeight Weight of the Grade
     */
    public void addGrade(int newGrade, int newWeight) {
        this.grades.add(new Grade(newGrade, newWeight));
        this.calculateAVG();
    }

    /**
     * Grades list getter
     *
     * @return grades
     */
    public List<Grade> getGrades() {
        return grades;
    }

    /**
     * Calculates the final grade using for-each loop
     */
    public void calculateAVG() {
        int totalWeight = 0;
        averageGrade = 0.f;

        //for-each loop
        for (Grade grd : grades) {
            this.averageGrade += grd.getGrade() * grd.getWeight();
            totalWeight += grd.getWeight();
        }

        this.averageGrade /= totalWeight;
    }

    /**
     * Final grade getter
     *
     * @return averageGrade
     */
    public Float getAVG() {
        return averageGrade;
    }
}
