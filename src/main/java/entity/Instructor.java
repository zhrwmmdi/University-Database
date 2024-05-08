package main.java.entity;
public class Instructor {
  private String ID;  
  private String name;
  private String dept_name;
  private float salary;

    public Instructor(String ID, String name, String dept_name, float salary) {
        this.ID = ID;
        this.name = name;
        this.dept_name = dept_name;
        this.salary = salary;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
  
  
}
