package main.java.entity;


public class Student {
    private String ID;
    private String name;
    private String dept_name;
    private int tot_cred;

    public Student(String ID, String name, String dept_name, int tot_cred) {
        this.ID = ID;
        this.name = name;
        this.dept_name = dept_name;
        this.tot_cred = tot_cred;
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

    public int getTot_cred() {
        return tot_cred;
    }

    public void setTot_cred(int tot_cred) {
        this.tot_cred = tot_cred;
    }
    public void increase_tot_cred(int value){
        this.tot_cred += value;
    }
}
