package io.github.mysterix5.studentclass;

import io.github.mysterix5.studentclass.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {


    @Test
    void getName() {
        Student s = new Student();
        assertEquals("name", s.getName());
    }

    @Test
    void setName() {
        Student s = new Student();
        s.setName("git");
        assertEquals("git", s.getName());
    }

    @Test
    void setCodewarsRanking(){
        Student s = new Student();
        s.setCodewarsRanking(100);
        assertEquals(100, s.getCodewarsRanking());
    }

    @Test
    void getCodewarsRanking() {
        Student s = new Student();
        assertEquals(0, s.getCodewarsRanking());
    }

    @Test
    void getCourse() {
        Student s = new Student();
        assertEquals("School of life", s.getCourse());
    }

    @Test
    void setCourse() {
        Student s = new Student();
        s.setCourse("muc-java-22-1");
        assertEquals("muc-java-22-1", s.getCourse());
    }

    @Test
    void testToString() {
        Student s = new Student();
        String s1 = "" + s;
        assertEquals("Student name is in School of life and is ranked 0", s1);
    }
    @Test
    void testToStringWithSettingValues() {
        Student s = new Student();
        s.setName("Lukas");
        s.setCourse("muc-java-22-1");
        s.setCodewarsRanking(124);
        String tostring = "" + s;
        assertEquals("Student Lukas is in muc-java-22-1 and is ranked 124", tostring);
    }
}
