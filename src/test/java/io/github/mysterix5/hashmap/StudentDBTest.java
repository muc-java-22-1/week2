package io.github.mysterix5.hashmap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDBTest {
    @Test
    void testList(){
        var students = createStudentArray();

        StudentDB studentDB = new StudentDB(students);

        assertTrue(students.containsAll(studentDB.list()));
        assertTrue(studentDB.list().containsAll(students));
        System.out.println(studentDB);
    }

    @Test
    void testToString() {
        List<Student> students = new ArrayList<>();
        Student s1 = new MathStudent();
        students.add(s1);
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
        students.add(newStudent);

        assertTrue(students.containsAll(studentDB.list()));
        assertTrue(studentDB.list().containsAll(students));
    }
    @Test
    void addThrowException() {
        var students = createStudentArray();
        var studentDB = new StudentDB(students);
        Student newStudent = new HistoryStudent();

        studentDB.add(newStudent);
        try{
            studentDB.add(newStudent);
            fail();
        } catch(RuntimeException e){

        }
    }

    @Test
    void removeByStudent() {
        Student newStudent = new HistoryStudent();
        var students = createStudentArray();
        students.add(newStudent);
        var studentDB = new StudentDB(students);

        studentDB.removeByStudent(newStudent);
        students.remove(newStudent);

        assertTrue(students.containsAll(studentDB.list()));
        assertTrue(studentDB.list().containsAll(students));
    }


    @Test
    void removeById() {
        Student newStudent = new HistoryStudent();
        var students = createStudentArray();
        students.add(newStudent);
        var studentDB = new StudentDB(students);

        students.remove(newStudent);
        studentDB.removeById(newStudent.getID());

        assertTrue(students.containsAll(studentDB.list()));
        assertTrue(studentDB.list().containsAll(students));
    }

    @Test
    void sayHello(){
        var students = createStudentArray();
        for(var s: students) s.sayHello();
    }

    @Test
    void getById() {
        var students = createStudentArray();
        var studentDB = new StudentDB(students);
        Student newStudent = new HistoryStudent();
        studentDB.add(newStudent);

        assertEquals(newStudent, studentDB.getById(newStudent.getID()));
    }

    List<Student> createStudentArray(){
        List<Student> students = new ArrayList<>();
        var alf = new HistoryStudent("Alf", 1010, "how to eat cats properly");
        var et = new MathStudent("ET", 666, "how to call home");
        var data = new MathStudent("Data", 2, "how to feel");
        var luke = new HistoryStudent("Luke", 123, "how to not kiss family members");
        students.add(alf);
        students.add(et);
        students.add(data);
        students.add(luke);
        return students;
    }

}