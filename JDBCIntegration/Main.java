import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO();

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Add Employee");
                  
                    System.out.println("Enter name: ");
                    String name=sc.nextLine();
                    System.out.println("Enter email: ");
                    String email=sc.nextLine();

                    System.out.println("Enter department: ");
                    String department=sc.nextLine();

                    System.out.println("Enter Salary: ");
                    double salary=sc.nextDouble();

                    Employee employee=new Employee(name,email,department,salary);
                    employeeDAO.insertEmployee(employee);

                    break;

                case 2:
                    System.out.println("\n--- All Employees ---");
                    employeeDAO.getAllEmployees();
                    break;

                case 3:
                    System.out.println("Update Employee");
                    System.out.println("Enter Employee ID to update: ");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter updated name: ");
                    String uname=sc.nextLine();
                    System.out.println("Enter updated email: ");
                    String uemail=sc.nextLine();
                    System.out.println("Enter updated department: ");
                    String udepartment=sc.nextLine();
                    System.out.println("Enter new salary: ");
                    double usalary=sc.nextDouble();
                    Employee uemployee=new Employee(uname, uemail, udepartment, usalary);
                    uemployee.setEmp_id(id);
                    employeeDAO.updateEmployee(uemployee);
                    break;

                case 4:
                    System.out.println("Delete Employee ");
                    System.out.println("Enter Employee ID to delete: ");
                    int d_id=sc.nextInt();
                    employeeDAO.deleteEmployee(d_id);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}