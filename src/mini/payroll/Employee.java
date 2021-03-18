/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.payroll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public abstract class Employee {
    
   protected String ID;
    protected String Name;
    protected String Age;
    protected float salary;

    public Employee(String ID, String Name, String Age) {
        this.ID = ID;
        this.Name = Name;
        this.Age = Age;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    
    public float getSalary() {
        return salary;
    }
    
    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getAge() {
        return Age;
    }
    
    public static void start() {
       try{
           FileReader engineerFr = new FileReader("Engineers.txt");
           BufferedReader engineerBr = new BufferedReader(engineerFr);
           FileReader traineeFr = new FileReader("Trainees.txt");
           BufferedReader traineeBr = new BufferedReader(traineeFr);
            String line = "";
            String split = ", ";
            while( (line = engineerBr.readLine()) != null){
                String[] data = line.split(split);
                Engineer e = new Engineer(data[0], data[1], data[2], Float.parseFloat(data[3]), data[4]);
                Engineer.engineerList.add(e);
            }
            
            while( (line = traineeBr.readLine()) != null){
                String[] data = line.split(split);
                Trainee t = new Trainee(data[0], data[1], data[2], data[3], Float.parseFloat(data[4]), Integer.parseInt(data[5]));
                Trainee.traineeList.add(t);
            }
           
       }catch(IOException exp){
            System.out.println("Can't Open the Files");
       }
    }
    
    public static void end() {
        try{
            FileWriter engineerFW = new FileWriter("Engineers.txt");
            Writer engineerWriter = new BufferedWriter(engineerFW);
            FileWriter traineeFW = new FileWriter("Trainees.txt");
            Writer traineeWriter = new BufferedWriter(traineeFW);
            
            for(int i = 0; i < Engineer.engineerList.size(); i++) {
                engineerWriter.write(Engineer.engineerList.get(i).getID()+", "+ 
                                     Engineer.engineerList.get(i).getName() +", "+
                                     Engineer.engineerList.get(i).getAge()+ ", "+
                                     Engineer.engineerList.get(i).getWorkingHours()+", "+
                                     Engineer.engineerList.get(i).getGrade().getPosition()+"\n");
            }
            for(int i = 0; i < Trainee.traineeList.size(); i++) {
                traineeWriter.write(Trainee.traineeList.get(i).getID()+ ", " +
                                    Trainee.traineeList.get(i).getName()+ ", " +
                                    Trainee.traineeList.get(i).getAge() + ", " +
                                    Trainee.traineeList.get(i).getUniName() + ", " +
                                    Trainee.traineeList.get(i).getGPA() + ", " +
                                    Trainee.traineeList.get(i).getAcademicYear()+ "\n");
            }
             engineerWriter.close();
             traineeWriter.close();
        }catch(IOException exp){
            System.out.println("Can't Open the Files");
        }
    }
   
}

