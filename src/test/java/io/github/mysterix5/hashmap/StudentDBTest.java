package io.github.mysterix5.hashmap;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentDBTest {
    @Test
    void testList(){
        var students = createStudentArray();

        StudentDB studentDB = new StudentDB(students);
        assertEquals(students, studentDB.list());
        System.out.println(studentDB);
    }

    @Test
    void testToString() {
        Map<String, Student> students = new HashMap<>();
        Student s1 = new MathStudent();
        students.put(s1.getID(), s1);
        StudentDB studentDB = new StudentDB(students);
        assertEquals("""
                        StudentDB:\s
                        Student name visits the course 'School of life' and is ranked 0 on CodeWars.
                        ------""",
                studentDB.toString());
    }

    @Test
    void randomStudent(){
        var students = createStudentArray();
        var studentDB = new StudentDB(students);
        var randomStudent = studentDB.randomStudent();
        assertEquals(studentDB.getById(randomStudent.getID()), randomStudent);
    }

    @Test
    void add() {
        var students = createStudentArray();
        var studentDB = new StudentDB(students);
        Student newStudent = new HistoryStudent();
        studentDB.add(newStudent);
        students.put(newStudent.getID(), newStudent);
        assertEquals(students, studentDB.list());
    }

    @Test
    void removeByStudent() {
        Student newStudent = new HistoryStudent();
        var students = createStudentArray();
        students.put(newStudent.getID(), newStudent);
        var studentDB = new StudentDB(students);
        studentDB.removeByStudent(newStudent);

        students.remove(newStudent.getID());
        assertEquals(students, studentDB.list());
    }


    @Test
    void removeById() {
        Student newStudent = new HistoryStudent();
        var students = createStudentArray();
        students.put(newStudent.getID(), newStudent);
        var studentDB = new StudentDB(students);

        students.remove(newStudent.getID());
        studentDB.removeById(newStudent.getID());

        assertEquals(students, studentDB.list());
    }

    @Test
    void sayHello(){
        var students = createStudentArray();
        for(var s: students.values()) s.sayHello();
    }

    @Test
    void getById() {
        var students = createStudentArray();
        var studentDB = new StudentDB(students);
        Student newStudent = new HistoryStudent();
        studentDB.add(newStudent);

        assertEquals(newStudent, studentDB.getById(newStudent.getID()));
    }

    Map<String, Student> createStudentArray(){
        Map<String, Student> students = new HashMap<>();
        var alf = new HistoryStudent("Alf", 1010, "how to eat cats properly");
        var et = new MathStudent("ET", 666, "how to call home");
        var data = new MathStudent("Data", 2, "how to feel");
        var luke = new HistoryStudent("Luke", 123, "how to not kiss family members");
        students.put(alf.getID(), alf);
        students.put(et.getID(), et);
        students.put(data.getID(), data);
        students.put(luke.getID(), luke);
        return students;
    }

}