// package JDBCIntegration;

public class Employee {

    private int emp_id;
    private String name;
    private String email;
    private String department;
    private double salary;

    public Employee(String name,String email,String department,double salary){
        this.name=name;
        this.email=email;
        this.department=department;
        this.salary=salary;
    }
    // public Employee(int emp_id,String name,String email,String department,double salary){
    //     this.emp_id=emp_id;
    //     this.email=email;
    //     this.department=department;
    //     this.salary=salary;
    // }
    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id){
        this.emp_id=emp_id;
    }
   
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
