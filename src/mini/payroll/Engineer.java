/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.payroll;

import java.util.ArrayList;
import java.util.Scanner;
        
public class Engineer extends Employee{
    
    private float WorkingHours;
    private Grade grade;
    public static ArrayList<Engineer> engineerList = new ArrayList<>();
    public boolean test=true;

    public Engineer(String ID, String Name, String Age, float WorkingHours, String position) {
        super(ID, Name, Age);
        this.WorkingHours = WorkingHours;
        this.grade = new Grade(position);
        this.salary = calc();
    }
    
    public float getWorkingHours() {
        return WorkingHours;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setWorkingHours(float WorkingHours) {
        this.WorkingHours = WorkingHours;
    }
    
    static int getEngineerIndex(String ID) {
        for(int i = 0; i < engineerList.size(); i++) {
            if(engineerList.get(i).getID().equals(ID)) {
                return i;
            }
        }
        return -1;
    }
    
    private float calc(){
        return this.WorkingHours * this.grade.getPayRate() * this.grade.getTaxRate();
    } 
    
    public static void getSalary(String ID) {
        int index = Engineer.getEngineerIndex(ID);
        if(index != -1) {
            System.out.println("Engineer Name: " + engineerList.get(index).getName());
            System.out.println("Engineer Salary: " + engineerList.get(index).getSalary());
        }else{
            System.out.println("You Entered Invalid ID");
        }
    }

    public static void add(Engineer en) {
        engineerList.add(en);
    }

    private static void salaryUpdate(int index) {
        float newSalary = engineerList.get(index).getGrade().getPayRate()*
                          engineerList.get(index).getGrade().getTaxRate()*
                          engineerList.get(index).getWorkingHours();
        engineerList.get(index).setSalary(newSalary);
    }
      public static void engineerInfoUpdateWH(String ID,Float wr){
           int index = Engineer.getEngineerIndex(ID);            
           engineerList.get(index).setWorkingHours(wr);
           salaryUpdate(index);          
      }
    
     public static void engineerInfoUpdateGrade(String ID,String p)
    {
          int index = Engineer.getEngineerIndex(ID);
            engineerList.get(index).getGrade().setPosition(p);
            salaryUpdate(index);
    }


    public static void delete(String id) {
        int index = Engineer.getEngineerIndex(id);
        engineerList.remove(index);
        System.out.println("Engineer has deleted Succesfully");
    }
    
   public  static void viewInfo(){
         for(Engineer e:engineerList){
             System.out.println("ID: "+ e.getID());
             System.out.println("Name: "+ e.getName());
             System.out.println("Age: "+ e.getAge());
             System.out.println("Salary: "+ e.getSalary());
             System.out.println("Working Hours: "+ e.getWorkingHours());
             System.out.println("Position: "+ e.getGrade().getPosition());
             System.out.println("Pay Rate: "+ e.getGrade().getPayRate());
             System.out.println("Tax Rate: "+ e.getGrade().getTaxRate());
             System.out.println("------------------------------------------------------------------------");
        }
    }
}
