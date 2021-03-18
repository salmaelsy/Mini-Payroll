package mini.payroll;

public class Grade {
    
    private String position;
    private float taxRate;
    private float payRate;

    public Grade(String position) {
        this.position = position;
        if(position.toLowerCase().equals("manager")) {
            this.payRate = 12.0F;
            this.taxRate = 10.0F;
        }if(position.toLowerCase().equals("team member")) {
            this.payRate = 8.0F;
            this.taxRate = 4.0F; 
        }if(position.toLowerCase().equals("team leader")) {
            this.payRate = 10.0F;
            this.taxRate = 6.0F;
        }
    }

    public float getTaxRate() {
        return taxRate;
    }

    public float getPayRate() {
        return payRate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
        if(position.toLowerCase().equals("manager")) {
            this.payRate = 12.0F;
            this.taxRate = 10.0F;
        }if(position.toLowerCase().equals("team member")) {
            this.payRate = 8.0F;
            this.taxRate = 4.0F; 
        }if(position.toLowerCase().equals("team leader")) {
            this.payRate = 10.0F;
            this.taxRate = 6.0F;
        }
    }
}
