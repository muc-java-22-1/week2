package io.github.mysterix5.studentDbArrayList;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentDBTest {
    @Test
    void testList(){
        var students = createStudentArray();

        StudentDB studentDB = new StudentDB(students);
        assertEquals(students, studentDB.list());

        //for(int i = 0; i<10; i++) System.out.println(students[i]);
    }

    @Test
    void testToString() {
        var students = createStudentArray();

        StudentDB studentDB = new StudentDB(students);
        System.out.println(studentDB);
        assertEquals(
                "Student Alf is in how to eat cats properly and is ranked 1010; Student ET is in how to call home and is ranked 666; Student Data is in how to feel and is ranked 120348; Student Luke is in how to not kiss family members and is ranked 123; ",
                studentDB.toString());
    }

    @Test
    void randomStudent(){
        var students = createStudentArray();
        var studentDB = new StudentDB(students);
        var randomStudent = studentDB.randomStudent();
        assertTrue(students.contains(randomStudent));
    }

    @Test
    void add() {
        var students = createStudentArray();
        var studentDB = new StudentDB(students);
        Student newStudent = new HistoryStudent();
        studentDB.add(newStudent);
        students.add(newStudent);
        assertEquals(students, studentDB.list());
    }

    @Test
    void remove() {
        Student newStudent = new HistoryStudent();
        var students = createStudentArray();
        students.add(newStudent);
        var studentDB = new StudentDB(students);
        studentDB.remove(newStudent);

        students.remove(newStudent);
        assertEquals(students, studentDB.list());
    }


    @Test
    void removeById() {
        Student newStudent = new HistoryStudent();
        var students = createStudentArray();
        students.add(newStudent);
        var studentDB = new StudentDB(students);
        students.remove(newStudent);

        String index = newStudent.getID();
        studentDB.remove(index);

        assertEquals(students, studentDB.list());
    }

    @Test
    void sayHello(){
        var students = createStudentArray();
        for(var s: students) s.sayHello();
    }

    ArrayList<Student> createStudentArray(){
        ArrayList<Student> students = new  ArrayList<Student>();
        students.add(new HistoryStudent("Alf", 1010, "how to eat cats properly"));
        students.add(new MathStudent("ET", 666, "how to call home"));
        students.add(new MathStudent("Data", 120348, "how to feel"));
        students.add(new HistoryStudent("Luke", 123, "how to not kiss family members"));
        return students;
    }

}