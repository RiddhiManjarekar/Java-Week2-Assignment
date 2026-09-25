package StudentManagementSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/*
  Manages student records and provides CRUD operations,
  average calculation, and data persistence.
*/

public class StudentManager {

    private List<Student> students = new ArrayList<>();

    private static final String FILE_NAME="students.dat";


    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found");
            return;
        }

        System.out.printf(
        "%-10s %-20s %-10s %-10s %-30s%n", 
        "ID", "Name", "Age", "Grade", "Subjects");
       
        System.out.println("--------------------------------------------------");

        for (Student student : students) {

            System.out.printf("%-10d %-20s %-10d %-10.2f %-30s%n",
                            student.getId(), student.getName(), student.getAge(),
                    student.getGrade(),
                    String.join(", ", student.getSubjects()));
        }

    }

    public void addStudent(Student student) {

        for (Student addedstudent : students) {
            if (addedstudent.getId().equals(student.getId())) {
                System.out.println("Student ID already exists");
                return;
            }

        }
        students.add(student);
        System.out.println("Student added");

    }

    public void searchStudent(String search) {

        boolean found = false;

        for (Student student : students) {
            if (student.getId().toString().equals(search) ||
                    student.getName().equalsIgnoreCase(search)) {

                System.out.println("Student found: " + student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found.");
        }
    }

    public void updateGrade(Long id, double grade) {

        for (Student student : students) {
            if (id.equals(student.getId())) {
                student.setGrade(grade);
                System.out.println("Grade updated");
                return;
            }
        }
        System.out.println("No student found");
    }

    public void updateSubjects(Long id, String[] subjects) {

        for (Student student : students) {
            if (id.equals(student.getId())) {
                student.setSubjects(subjects);
                System.out.println("Subjects updated");
                return;
            }
        }
        System.out.println("No student found");
    }

    public void deleteStudent(Long id) {

        boolean removed = students.removeIf(student -> id.equals(student.getId()));

        if (removed) {
            System.out.println("Student deleted");
        } else {
            System.out.println("No student found with given ID");
        }

    }

    public void calculateAverage() {
        if (students.isEmpty()) {
            System.out.println("No students found");
            return;
        }
        double total = 0;
        for (Student student : students) {
            total += student.getGrade();
        }
        double average = total / students.size();

        System.out.printf("Class average grade: %.2f%%%n", average);
    }

    public void saveToFile(){
        try (ObjectOutputStream opStream=
            new ObjectOutputStream(
                new FileOutputStream(FILE_NAME)))  {
            
            opStream.writeObject(students);
            System.out.println("Students data saved in the file");
            
        } catch (IOException e) {
            System.out.println("Error writing data to file: "+e.getMessage());
        }
    }

    @SuppressWarnings("unchecked") 
    public void loadFromFile(){
        try (ObjectInputStream ipStream=
            new ObjectInputStream(
                new FileInputStream(FILE_NAME)))  {

        students=(List<Student>) ipStream.readObject();
        System.out.println("Student data loaded");
            
        } catch (IOException e) {
            System.out.println("No student data found "+e.getMessage());
        } catch(ClassNotFoundException e){
            System.out.println("Student class not found: "+e.getMessage());
        }
    }

}
