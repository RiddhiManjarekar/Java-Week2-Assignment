package StudentManagementSystem;

import java.io.Serializable;
import java.util.Arrays;

/*
 Represents a student in the Student Management System.
*/

public class Student implements Serializable{

    private static final long serialVersionUID=1L;

    private Long id;
    private String name;
    private int age;
    private double grade;
    private String[] subjects;

    public Student(Long id,String name,int age,double grade,String[] subjects){
        this.id=id;
        this.name=name;
        this.age=age;
        this.grade=grade;
        this.subjects=subjects;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public String[] getSubjects() {
        return subjects;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + ", grade=" + grade + ", subjects="
                + Arrays.toString(subjects) + "]";
    }

}