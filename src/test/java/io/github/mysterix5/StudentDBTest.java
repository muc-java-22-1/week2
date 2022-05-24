package io.github.mysterix5;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentDBTest {
    @Test
    void testList(){
        var students = createStudentArray();

        StudentDB studentDB = new StudentDB(students);
        assertArrayEquals(students, studentDB.list());

        //for(int i = 0; i<10; i++) System.out.println(students[i]);
    }

    @Test
    void testToString() {
        var students = createStudentArray();

        StudentDB studentDB = new StudentDB(students);
        System.out.println(studentDB.toString());
        assertEquals(
                "Student Alf is in how to eat cats properly and is ranked 1010; Student ET is in how to call home and is ranked 666; Student Data is in how to feel and is ranked 120348; Student Luke is in how to not kiss family members and is ranked 123; ",
                studentDB.toString());
    }

    @Test
    void randomStudent(){
        var students = createStudentArray();
        var studentDB = new StudentDB(students);
        var randomStudent = studentDB.randomStudent();
        assertTrue(Arrays.asList(students).contains(randomStudent));
    }

    @Test
    void add() {
        var students = createStudentArray();
        var studentDB = new StudentDB(students);
        var newStudent = new Student();
        studentDB.add(newStudent);
        Student[] s1 = new Student[students.length+1];
        for(int i = 0; i<students.length; i++) s1[i] = students[i];
        s1[students.length] = newStudent;
        assertArrayEquals(s1, studentDB.list());
    }

    @Test
    void remove() {
        var students = createStudentArray();
        var studentDB = new StudentDB(students);
        int etsId = studentDB.getByArrayIndex(1).getID();
        studentDB.remove(etsId);
        System.out.println(studentDB);

        Student[] studentsActual = new Student[3];
        studentsActual[0] = new Student("Alf", 1010, "how to eat cats properly");
        studentsActual[1] = new Student("Data", 120348, "how to feel");
        studentsActual[2] = new Student("Luke", 123, "how to not kiss family members");

        assertArrayEquals(studentsActual, studentDB.list());
    }

//    Student[] createStudentArray(){
//        Student[] students = new Student[10];
//        for(int i = 0; i<10; i++) students[i] = new Student();
//        return students;
//    }
    Student[] createStudentArray(){
        Student[] students = new Student[4];
        students[0] = new Student("Alf", 1010, "how to eat cats properly");
        students[1] = new Student("ET", 666, "how to call home");
        students[2] = new Student("Data", 120348, "how to feel");
        students[3] = new Student("Luke", 123, "how to not kiss family members");
        return students;
    }

}