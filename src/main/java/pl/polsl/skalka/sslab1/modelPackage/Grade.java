/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.skalka.sslab1.modelPackage;

/**
 * @version 1.0
 * @author szymon skalka
 */
public final class Grade {

    /**
     * grade
     */
    private int grade;
    /**
     * weight of the grade
     */
    private int weight;

    /**
     * Constructor
     *
     * @param newGrade Grade
     * @param newWeight Weight
     */
    public Grade(int newGrade, int newWeight) {
        setGrade(newGrade);
        setWeight(newWeight);
    }

    ;
        
        
        /**
         * Grade setter
         * @param newGrade Grade
         */
        public void setGrade(int newGrade) {
        this.grade = newGrade;
    }

    /**
     * Grade getter
     *
     * @return grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Weight setter
     *
     * @param newWeight weight
     */
    public void setWeight(int newWeight) {
        this.weight = newWeight;
    }

    /**
     * Weight getter
     *
     * @return weight
     */
    public int getWeight() {
        return weight;
    }

}
