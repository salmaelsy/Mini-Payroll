/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.payroll;

import java.util.ArrayList;
import java.util.Scanner;

public class Trainee extends Employee{
    
   private String UniName;
    private float GPA;
    private int AcademicYear;
    public static ArrayList<Trainee> traineeList = new ArrayList<>();

    public Trainee(String ID, String Name, String Age, String UniName, float GPA, int AcademicYear) {
        super(ID, Name, Age);
        this.UniName = UniName;
        this.GPA = GPA;
        this.AcademicYear = AcademicYear;
        this.salary = 1000.0F;
    }

    public String getUniName() {
        return UniName;
    }

    public float getGPA() {
        return GPA;
    }

    public int getAcademicYear() {
        return AcademicYear;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    public void setAcademicYear(int AcademicYear) {
        this.AcademicYear = AcademicYear;
    }
    
    private static int getTraineeIndex(String id) {
        for(int i = 0; i < traineeList.size(); i++) {
            if(traineeList.get(i).getID().equals(id)) {
                return i;
            }
        }
        return -1;
    }
    
    public static void add(Trainee e) {     
        traineeList.add(e);      
    }
    public static void TraineeInfoUpDateGpa(String ID,Float gpa){
        int index = Trainee.getTraineeIndex(ID);
            traineeList.get(index).setGPA(gpa);
    }
    public static void TraineeInfoUpDateAcaYear(String ID,int year)
    {       
           int index = Trainee.getTraineeIndex(ID);   
            traineeList.get(index).setAcademicYear(year);
    }


    public static void delete(String id) {
        int index = Trainee.getTraineeIndex(id);
        traineeList.remove(index);
    }

    public static void viewInfo() {
         for(Trainee t:traineeList){
             System.out.println("ID: "+t.getID());
             System.out.println("Name: "+ t.getName());
             System.out.println("Age: "+ t.getAge());
             System.out.println("University Name: "+t.getUniName());
             System.out.println("GPA: "+t.getGPA());
             System.out.println("Academic Year: "+t.getAcademicYear());
             System.out.println("Salary : "+t.getSalary());
             System.out.println("------------------------------------------------------------------------");
        }
    }
}
