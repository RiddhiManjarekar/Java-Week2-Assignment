package StudentManagementSystem;

import java.util.Scanner;

public class Main {

    private static int scanInteger(Scanner sc, String msg) {
        while (true) {
            System.out.println(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input! Please Enter a number");
            }
        }
    }

    private static Long scanLong(Scanner sc,String msg){
        while (true) {
        System.out.println(msg);
         try {
            Long num=Long.parseLong(sc.nextLine().trim());
            if(num<=0){
                System.out.println("ID must be greater than 0");
                continue;
            }
            return num;
         } catch (NumberFormatException e) {
             System.out.println("Invalid Input! Please Enter a number");
         }
       }
    }

    private static String scanName(Scanner sc, String msg) {
        while (true) {
            System.out.println(msg);
            String name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty");
                continue;
            }
            return name;
        }

    }

    private static int scanAge(Scanner sc, String msg) {
        while (true) {
            int age = scanInteger(sc, msg);

            if (age <= 0 || age > 100) {
                System.out.println("Age must be between 1 & 100");
                continue;
            }

            return age;

        }
    }

    private static double scanGrade(Scanner sc, String msg) {
        while (true) {
            System.out.println(msg);

            try {
                double grade = Double.parseDouble(sc.nextLine().trim());
                if (Double.isNaN(grade) || Double.isInfinite(grade)) {
                    System.out.println("Invalid grade");
                    continue;
                }
                if (grade < 0 || grade > 100) {
                    System.out.println("Grade must be between 0 and 100");
                    continue;
                }
                return grade;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }

        }
    }

    private static int scanSubjectCount(Scanner sc, String msg) {
        while (true) {
            int count = scanInteger(sc, msg);

            if (count <= 0) {
                System.out.println("Please enter at least 1 subject");
                continue;
            }
            return count;

        }
    }

    private static String[] scanSubjects(Scanner sc, int count) {
        String[] subjects = new String[count];
        System.out.println("Now enter subject names:");

        for (int i = 0; i < count; i++) {
            while (true) {
                System.out.println("Subject "+(i+1)+":");
                String subject = sc.nextLine().trim();

                if (subject.isEmpty()) {
                    System.out.println("Subject name not provided");
                    continue;
                }
                boolean isDuplicate=false;

                for(int k=0;k<i;k++){
                    if(subjects[k].equalsIgnoreCase(subject)){
                        isDuplicate=true;
                        break;
                    }
                }
                if(isDuplicate){
                    System.out.println("Subject already taken!Please Enter diffrent one!");
                    continue;
                }
                subjects[i]=subject;
                break;
            }
        }
        return subjects;

    }

    private static boolean scanConfirmation(Scanner sc,String msg){
        while (true) {
            System.out.println(msg);
            String confirmation=sc.nextLine().trim();

            if(confirmation.equalsIgnoreCase("yes")
            || confirmation.equalsIgnoreCase("y")){
                return true;
            }

            if(confirmation.equalsIgnoreCase("no")
            || confirmation.equalsIgnoreCase("n")){
                return false;
        
            }
            System.out.println("Please Enter Yes or No");
            
        }
    }

   

    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        sm.loadFromFile();
        int choice;
        Scanner sc = new Scanner(System.in);

       
            do {

                System.out.println("*** Student Management System ***");

                System.out.println("1. Add Student");
                System.out.println("2. Display Students");
                System.out.println("3. Search Student");
                System.out.println("4. Update Grade");
                System.out.println("5. Update Subjects");
                System.out.println("6. Delete Student");
                System.out.println("7. Calculate Average");
                System.out.println("8.Exit");
                
                choice =scanInteger(sc,"Enter your choice: ");
                switch (choice) {

                    case 1:
                        System.out.println("Enter student details...");
                        
                        Long id = scanLong(sc,"Enter student Id: ");
                        
                        String name = scanName(sc,"Enter student name: ");

                        int age = scanAge(sc,"Enter student age: ");
                        
                        double grade = scanGrade(sc,"Enter student grade: ");

                        int n = scanSubjectCount(sc,"Enter number of subjects: ");

                        String[] subjects = scanSubjects(sc,n);
                       
                        Student student = new Student(id, name, age, grade, subjects);

                        sm.addStudent(student);
                        break;

                    case 2:
                        System.out.println("***These are the students here***");
                        sm.displayStudents();
                        break;

                    case 3:

                        System.out.println("Search Student by ID or Name:");

                        String search = sc.nextLine().trim();
                        if (search.isEmpty()) {
                            System.out.println("Search value not provided");
                            continue;
                        }
                        sm.searchStudent(search);
                        break;

                    case 4:
                        System.out.println("*** Update Student Grade ***");

                        Long updateGradeId = scanLong(sc,"ENter Student ID: ");

                        double updatedGrade = scanGrade(sc,"Enter updated grade:");

                        sm.updateGrade(updateGradeId, updatedGrade);
                        break;

                    case 5:

                        System.out.println("***Update Student Subjects***");

                        Long updateSubjectId = scanLong(sc,"Enter Student ID: ");
                                                
                        int subSize = scanSubjectCount(sc, "ENter  number of subjects: ");

                        String[] updatedSubjects=scanSubjects(sc, subSize);

                        sm.updateSubjects(updateSubjectId, updatedSubjects);
                        break;

                    case 6:
                        System.out.println("***Delete Student***");
                        
                        Long deleteId = scanLong(sc,"Enter student ID: ");
                        boolean confirm=scanConfirmation(sc, "Are you sure you want to delete this student?");
                        
                        if(confirm){
                            sm.deleteStudent(deleteId);
                        } else{
                            System.out.println("Cancelled");
                        }
                        
                        break;

                    case 7:
                        System.out.println("*** AVERAGE ***");
                        sm.calculateAverage();
                        break;

                    case 8:
                        sm.saveToFile();
                        System.out.println("Exit");
                        break;

                    default:
                        System.out.println("Invalid Choice! Choose between 1 and 8 ");
                        break;

                }
            } while (choice != 8);
            sc.close();

    }

}
