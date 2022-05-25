package io.github.mysterix5.inheritance;

import java.util.Objects;
import java.util.UUID;

public class Student {
    final private String ID = UUID.randomUUID().toString();
    private String name;
    private int codewarsRanking;
    private String course;

    public Student() {
        name = "name";
        codewarsRanking = 0;
        course = "School of life";
    }

    public Student(String name, int codewarsRanking, String course){
        this.name = name;
        this.codewarsRanking = codewarsRanking;
        this.course = course;
    }


    @Override
    public String toString() {
        return "Student " + getName() + " is in " + getCourse() + " and is ranked " + getCodewarsRanking();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCodewarsRanking(int i) {
        this.codewarsRanking = i;
    }

    public int getCodewarsRanking() {
        return codewarsRanking;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getID() {
        return this.ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return codewarsRanking == student.codewarsRanking && Objects.equals(name, student.name) && Objects.equals(course, student.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, codewarsRanking, course);
    }
}
