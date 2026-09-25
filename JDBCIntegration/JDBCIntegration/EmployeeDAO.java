package JDBCIntegration;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

    public void createTables() {

        String sql = """
                CREATE TABLE IF NOT EXISTS EMPLOYEES(
                ID INT PRIMARY KEY AUTO_INCREMENT,
                NAME VARCHAR(100) NOT NULL,
                EMAIL VARCHAR(150) NOT NULL UNIQUE,
                DEPARTMENT VARCHAR(100),
                SALARY DECIMAL(10,2)
                )
                """;

        try (Connection con = DatabaseConnection.getConnection();
                Statement stmt = con.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Employees table created!");

        } catch (SQLException e) {
            System.out.println("Failed to create employees table!" + e.getMessage());
        }
    }

    public void insertEmployee(Employee employee) {
        String sql = """
                INSERT INTO EMPLOYEES(name,email,department,salary)
                VALUES(?,?,?,?)
                """;

        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getDepartment());
            ps.setDouble(4, employee.getSalary());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee inserted!");
            }

        } catch (SQLException e) {
            System.out.println("Failed to insert employee! " + e.getMessage());
        }
    }

    public void getAllEmployees() {
        String sql = "SELECT * FROM EMPLOYEES";

        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int emp_id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String email = rs.getString("EMAIL");
                String department = rs.getString("DEPARTMENT");
                double salary = rs.getDouble("SALARY");

                Employee employee = new Employee(name, email, department, salary);

                employee.setEmp_id(emp_id);

                System.out.println(
                        employee.getEmp_id() + " | " +
                                employee.getName() + " | " +
                                employee.getEmail() + " | " +
                                employee.getDepartment() + " | " +
                                employee.getSalary());
            }

        } catch (SQLException e) {
            System.out.println("Failed to find employees! " + e.getMessage());
        }
    }

    public void updateEmployee(Employee employee) {
        String sql = """
                UPDATE EMPLOYEES
                SET NAME=?,EMAIL=?,DEPARTMENT=?,SALARY=?
                WHERE ID=?
                """;

        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getDepartment());
            ps.setDouble(4, employee.getSalary());
            ps.setInt(5, employee.getEmp_id());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee updated!");
            } else {
                System.out.println("Employee not found!");
            }
        } catch (SQLException e) {
            System.out.println("Failed to update employee! " + e.getMessage());
        }

    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM EMPLOYEES WHERE ID=?";
        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee deleted!");
            } else {
                System.out.println("Employee not found!");
            }

        } catch (SQLException e) {
            System.out.println("Failed to delete employee! " + e.getMessage());
        }
    }

}
